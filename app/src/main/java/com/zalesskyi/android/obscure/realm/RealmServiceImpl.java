package com.zalesskyi.android.obscure.realm;

import io.realm.Realm;
import io.realm.RealmObject;
import io.realm.RealmResults;
import rx.Observable;
import rx.Scheduler;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Алексей on 14.04.2018.
 */

public class RealmServiceImpl implements IRealmService {
    private Realm mRealm;

    public RealmServiceImpl(Realm realm) {
        mRealm = realm;
    }

    @Override
    public Realm get() {
        return null;
    }

    @Override
    public void closeRealm() {

    }

    @Override
    public void refresh() {

    }

    @Override
    public <T extends RealmObject> Observable<T> addObject(T object, Class<T> clazz) {
        long id;
        try {
            id = mRealm.where(clazz).max("id").intValue() + 1;
        } catch (Exception e) {
            id = 0L;
        }
        ((User) object).setId(id);
        return Observable.just(object)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnError(Throwable::printStackTrace)
                .flatMap(t -> Observable.just(t)
                        .doOnSubscribe(mRealm::beginTransaction)
                        .doOnUnsubscribe(() -> {
                            mRealm.commitTransaction();
                        })
                        .doOnError(Throwable::printStackTrace)
                        .doOnNext(next -> mRealm.copyToRealmOrUpdate(next))
                );
    }

    @Override
    public <T extends RealmObject> Observable<RealmResults<T>> getObjects(Class<T> clazz) {
        return Observable.just(clazz)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .flatMap(t -> Observable.just(t)
                        .doOnSubscribe(mRealm::beginTransaction)
                        .doOnUnsubscribe(mRealm::commitTransaction))
                .map(type -> mRealm.where(clazz).findAll());
    }

    @Override
    public <T extends RealmObject> Observable<Class<T>> deleteObject(long id, Class<T> clazz) {
        return Observable.just(clazz)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe(mRealm::beginTransaction)
                .doOnUnsubscribe(mRealm::commitTransaction)
                .doOnError(Throwable::printStackTrace)
                .doOnNext(type -> {
                    mRealm.where(type).equalTo("realm_id", id).findFirst().deleteFromRealm();
                });
    }

    @Override
    public <T extends RealmObject> Observable<Class<T>> deleteAllObjects(Class<T> clazz) {
        return Observable.just(clazz)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe(mRealm::beginTransaction)
                .doOnUnsubscribe(mRealm::commitTransaction)
                .doOnError(Throwable::printStackTrace)
                .doOnNext(type -> mRealm.where(clazz).findAll().clear());
    }

    @Override
    public <T extends RealmObject> Observable<T> getLastObject(Class<T> clazz) {
        return Observable.just(clazz)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .flatMap(t -> Observable.just(t)
                        .doOnSubscribe(mRealm::beginTransaction)
                        .doOnUnsubscribe(mRealm::commitTransaction))
                .map(type -> mRealm.where(clazz).findAll().last());
    }
}