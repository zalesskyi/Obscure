package com.zalesskyi.android.obscure.package_presenters;

import android.app.Application;

import com.zalesskyi.android.obscure.interactors.IInteractorContract;
import com.zalesskyi.android.obscure.realm.IRealmService;
import com.zalesskyi.android.obscure.utils.INetworkCheck;
import com.zalesskyi.android.obscure.utils.IValidator;
import com.zalesskyi.android.obscure.view.IBaseView;
import com.zalesskyi.android.obscure.view.detail_operation.listeners.IDetailListener;

public class DetailPresenterImpl extends BasePresenter<IBaseView.IDetailView>
        implements IPresenterContract.IDetailPresenter {

    public DetailPresenterImpl(Application application, IInteractorContract interactor,
                             IValidator validator, INetworkCheck networkCheck, IRealmService realmService) {
        this.application = application;
        this.interactor = interactor;
        this.validator = validator;
        this.networkCheck = networkCheck;
        this.realmService = realmService;
    }

    @Override
    public void doGetCountries(Integer limit, Integer offset, IDetailListener.LocationListCallback callback) {
        interactor.toDoGetCountriesList(limit, offset)
                .subscribe(next -> {
                    if (next != null) {
                        // todo callback.showLocationList();
                        view.showError(next.getAsString());
                    }
                }, err -> view.showError(err.getMessage()), () -> {});
    }

    @Override
    public void doGetStates(Integer countryId, Integer limit, Integer offset, IDetailListener.LocationListCallback callback) {
        interactor.toDoGetRegionsList(countryId, limit, offset)
                .subscribe(next -> {
                    if (next != null) {
                        // todo callback.showLocationList();
                        view.showError(next.getAsString());
                    }
                }, err -> view.showError(err.getMessage()), () -> {});
    }

    @Override
    public void doGetCities(Integer stateId, Integer limit, Integer offset, IDetailListener.LocationListCallback callback) {
        interactor.toDoGetCitiesList(stateId, limit, offset)
                .subscribe(next -> {
                    if (next != null) {
                        // todo callback.showLocationList();
                        view.showError(next.getAsString());
                    }
                }, err -> view.showError(err.getMessage()), () -> {});
    }
}
