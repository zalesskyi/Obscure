package com.zalesskyi.android.obscure.package_presenters;

import android.app.Application;
import android.util.Log;

import com.zalesskyi.android.obscure.interactors.IInteractorContract;
import com.zalesskyi.android.obscure.model.Event;
import com.zalesskyi.android.obscure.model.Owner;
import com.zalesskyi.android.obscure.model.Place;
import com.zalesskyi.android.obscure.realm.IRealmService;
import com.zalesskyi.android.obscure.realm.User;
import com.zalesskyi.android.obscure.utils.INetworkCheck;
import com.zalesskyi.android.obscure.utils.IValidator;
import com.zalesskyi.android.obscure.view.IBaseView;
import com.zalesskyi.android.obscure.view.main_operation.activities.MainActivity;
import com.zalesskyi.android.obscure.view.main_operation.listeners.IMainListener;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Алексей on 20.04.2018.
 */

public class MainPresenterImpl extends BasePresenter<IBaseView.IMainView>
        implements IPresenterContract.IMainPresenter {

    public MainPresenterImpl(Application application, IInteractorContract interactor,
                             IValidator validator, INetworkCheck networkCheck, IRealmService realmService) {
        this.application = application;
        this.interactor = interactor;
        this.validator = validator;
        this.networkCheck = networkCheck;
        this.realmService = realmService;
    }

    @Override
    public void doLogout(String token, int type) {
        // todo сделать дома
        realmService.deleteObject(1, User.class).subscribe((next) -> {
            view.closeMain();
        }, (err) -> {
            view.showError(err.getMessage());
        });
    }

    @Override
    public void doGetFeed(IMainListener.IDashboardCallback callback) {
        realmService.getObjects(Event.class).doOnRequest(l -> view.showProgress())
                .subscribe(next -> {
                    if (next.size() == 0) {
                        callback.showEmptyList();
                    } else {
                        ArrayList<Event> es = new ArrayList<>();
                        for (Event e : next) {
                            es.add(e);
                        }
                        callback.showFeed(es);
                    }
                }, err -> {
                    Log.e(MainActivity.TAG, err.getMessage());
                    view.showError(err.getMessage());
                }, () -> view.hideProgress());
    }

    @Override
    public void doGetUsers(Integer limit, Integer offset) {
        interactor.toDoGetUsersList(limit, offset).doOnRequest(l -> view.showProgress()) // todo выполняется в том же потоке, что и начальный поток?
                .subscribe(next -> {
                    if (next != null) {
                        // todo
                        Log.i("MainPresenter", next.getAsString());
                        view.showError(next.getAsString());
                    }
                }, err -> view.showError(err.getMessage()), () -> Log.i("MainPresenter", "onCompleted"));
    }

    @Override
    public void doEditProfile(Integer countryId, Integer stateId, Integer cityId,
                              String name, String lastName, Integer imageId) {
        interactor.toDoEditProfile(countryId, stateId, cityId, name, lastName, imageId)
                .subscribe(next -> {
                    if (next != null) {
                        // todo
                        Log.i("MainPresenter", next.getAsString());
                        view.showError(next.getAsString());
                    }
                }, err -> view.showError(err.getMessage()),
                        () -> Log.i("MainPresenter", "onCompleted"));
    }

    @Override
    public void init(IBaseView.IMainView view) {
        super.init(view);
        //getMoc();
    }

    @Override
    public void dismiss() {
        super.dismiss();
    }

    //-------------------------------------------------------------------------------------------------------

    private void getMoc() {
        List<Event> events = new ArrayList<>();

        String[] photosUrls = new String[] {
                "https://images.pexels.com/photos/236047/pexels-photo-236047.jpeg?auto=compress&cs=tinysrgb&h=350",
                "https://www.planwallpaper.com/static/images/2ba7dbaa96e79e4c81dd7808706d2bb7_large.jpeg",
                "https://images.oyster.com/articles/18446-yellowstone.jpg",
                "https://www.nature.org/cs/groups/webcontent/@web/documents/media/2016-photocontest-yosemite-w-1.jpg",
                "http://www.nature.com/nature/journal/v546/n7658/images/546349a-i1.jpg"
        };

        Place place1 = new Place(41.001840, 28.929834);
        Place place2 = new Place(42.958805, 62.117283);
        Place place3 = new Place(49.964020, 8.592401);
        Place place4 = new Place(53.675864, 23.806594);
        Place place5 = new Place(60.762876, 10.252082);
        Place place6 = new Place(46.740328, 110.398543);
        Place place7 = new Place(54.799057, 32.063126);
        Place place8 = new Place(-19.464994, 17.697311);
        Place place9 = new Place(52.193635, 0.736614);
        Place place10 = new Place(20.221067, 77.073060);
        Place place11 = new Place(51.048673, -107.381090);
        Place place12 = new Place(34.511300, -105.174314);
        Place place13 = new Place(-7.345948, -62.608199);
        Place place14 = new Place(-31.499167, -65.381019);
        Place place15 = new Place(-23.500195, 149.648047);
        Place place16 = new Place(37.317084, 91.637350);
        Place place17 = new Place(26.364976, 43.361036);
        Place place18 = new Place(39.634548, 21.418667);
        Place place19 = new Place(33.908921, -0.164310);
        Place place20 = new Place(38.478650, 140.427034);

        Owner user1 = new Owner("Вильгельм II",  "https://upload.wikimedia.org/wikipedia/commons/thumb/9/93/Bundesarchiv_Bild_146-2004-0096%2C_Kaiser_Wilhelm_II..jpg/267px-Bundesarchiv_Bild_146-2004-0096%2C_Kaiser_Wilhelm_II..jpg");
        Owner user2 = new Owner ("Джон Першинг", "https://upload.wikimedia.org/wikipedia/commons/thumb/e/e9/General_John_Joseph_Pershing_head_on_shoulders.jpg/1200px-General_John_Joseph_Pershing_head_on_shoulders.jpg");
        Owner user3 = new Owner ("Пауль фон Гінденбург", "http://vimpel-v.com/uploads/posts/2014-07/1405510938_hindenburg.jpg");
        Owner user4 = new Owner ("Мустафа Кемаль Ататюрк", "http://russian7.ru/wp-content/uploads/2014/08/Atat%C3%BCrk.jpg");
        Owner user5 = new Owner ("Ерих Людендорф", "https://upload.wikimedia.org/wikipedia/commons/thumb/a/ad/Erich_Ludendorff.jpg/1200px-Erich_Ludendorff.jpg");
        Owner user6 = new Owner("Хейг Дуглас",  "https://upload.wikimedia.org/wikipedia/commons/7/70/Douglas_Haig.jpg");
        Owner user7 = new Owner ("Фердинанд Фош", "https://warspot-asset.s3.amazonaws.com/articles/pictures/000/015/573/content/2.jpg");
        Owner user8 = new Owner ("Герберт Кітченер", "http://static.oper.ru/data/site/horatio_herbert_kitchener-2_1.jpg");
        Owner user9 = new Owner ("Юзеф Пилсудский", "https://upload.wikimedia.org/wikipedia/commons/thumb/3/3b/Jozef_Pilsudski1.jpg/267px-Jozef_Pilsudski1.jpg");
        Owner user10 = new Owner("Аршинар Луи", "https://upload.wikimedia.org/wikipedia/commons/thumb/c/c5/Louis_Archinard.jpg/300px-Louis_Archinard.jpg");
        Owner user11 = new Owner("Енвер-паша", "https://upload.wikimedia.org/wikipedia/commons/thumb/3/32/Ismail_Enver.jpg/270px-Ismail_Enver.jpg");
        Owner user12 = new Owner("Виктор Эммануил III", "https://st.kp.yandex.net/images/actor_iphone/iphone360_329046.jpg");
        Owner user13 = new Owner("Жозеф Жоффр","http://biopeoples.ru/uploads/posts/2011-09/1315768037_joffr.jpg");
        Owner user14 = new Owner("Кадорна Луиджи", "https://upload.wikimedia.org/wikipedia/commons/thumb/3/30/Luigi_Cadorna_02.jpg/267px-Luigi_Cadorna_02.jpg");
        Owner user15 = new Owner("Ахмед Джемаль-паша","https://upload.wikimedia.org/wikipedia/commons/thumb/4/48/Ahmed_Djemal_-_Project_Gutenberg_eText_10338.png/236px-Ahmed_Djemal_-_Project_Gutenberg_eText_10338.png");
        Owner user16 = new Owner("Юзеф Галлер","https://upload.wikimedia.org/wikipedia/commons/thumb/a/ae/Jozef_Haller.jpg/1200px-Jozef_Haller.jpg");
        Owner user17 = new Owner("Фалькенхайн, Эрих фон", "https://upload.wikimedia.org/wikipedia/commons/thumb/6/64/Erich_von_Falkenhayn.jpg/1200px-Erich_von_Falkenhayn.jpg");
        Owner user18 = new Owner("Армандо Диас","https://upload.wikimedia.org/wikipedia/commons/thumb/6/6a/Armando_Diaz.jpg/200px-Armando_Diaz.jpg");
        Owner user19 = new Owner("Конрад фон Хётцендорф", "https://upload.wikimedia.org/wikipedia/commons/thumb/f/f2/Franz_Graf_Conrad_von_Hoetzendorf.jpg/200px-Franz_Graf_Conrad_von_Hoetzendorf.jpg");
        Owner user20 = new Owner("Пётр I Карагеоргиевич", "https://upload.wikimedia.org/wikipedia/commons/thumb/c/c6/PetarI-Karadjordjevic.jpg/280px-PetarI-Karadjordjevic.jpg");

        Event event = new Event();
        event.setOwner(user1);
        event.setPlace(place1);

        events.add(event);

        Event event1 = new Event();
        event1.setOwner(user2);
        event1.setPlace(place2);

        events.add(event1);

        Event event2 = new Event();
        event2.setOwner(user3);
        event2.setPlace(place3);

        events.add(event2);

        Event event3 = new Event();
        event3.setOwner(user4);
        event3.setPlace(place4);

        events.add(event3);

        Event event4 = new Event();
        event4.setOwner(user5);
        event4.setPlace(place5);

        events.add(event4);

        Event event5 = new Event();
        event5.setOwner(user6);
        event5.setPlace(place6);

        events.add(event5);

        Event event6 = new Event();
        event6.setOwner(user7);
        event6.setPlace(place7);

        events.add(event6);

        Event event7 = new Event();
        event7.setOwner(user8);
        event7.setPlace(place8);

        events.add(event7);

        Event event8 = new Event();
        event8.setOwner(user9);
        event8.setPlace(place9);

        events.add(event8);

        Event event9 = new Event();
        event9.setOwner(user10);
        event9.setPlace(place10);

        events.add(event9);

        Event event10 = new Event();
        event10.setOwner(user11);
        event10.setPlace(place11);

        events.add(event10);

        Event event11 = new Event();
        event11.setOwner(user12);
        event11.setPlace(place12);

        events.add(event11);

        Event event12 = new Event();
        event12.setOwner(user13);
        event12.setPlace(place13);

        events.add(event12);

        Event event13 = new Event();
        event13.setOwner(user14);
        event13.setPlace(place14);

        events.add(event13);

        Event event14 = new Event();
        event14.setOwner(user15);
        event14.setPlace(place15);

        events.add(event14);

        Event event15 = new Event();
        event15.setOwner(user16);
        event15.setPlace(place16);

        events.add(event15);

        Event event16 = new Event();
        event16.setOwner(user17);
        event16.setPlace(place17);

        events.add(event16);

        Event event17 = new Event();
        event17.setOwner(user18);
        event17.setPlace(place18);

        events.add(event17);

        Event event18 = new Event();
        event18.setOwner(user19);
        event18.setPlace(place19);

        events.add(event18);

        Event event19 = new Event();
        event19.setOwner(user20);
        event19.setPlace(place20);

        events.add(event19);

        Random rand = new Random();
        for (Event e : events) {
            e.setId(rand.nextInt(100000000));
            e.setUrlToPhoto(photosUrls[rand.nextInt(5)]);
            add(e);
        }
    }

    private void add(Event event) {
        realmService.addObject(event, Event.class).subscribe(next -> {
            if (next != null) {
                Log.i("RETy", "MainPresenterImpl_next " + next);
            }
        });
    }
}
