package com.zalesskyi.android.obscure.package_presenters;

import com.zalesskyi.android.obscure.view.IBaseView;

public class DetailPresenterImpl extends BasePresenter<IBaseView.IDetailView>
        implements IPresenterContract.IDetailPresenter {

    @Override
    public void doGetCountries(Integer limit, Integer offset) {
        interactor.toDoGetCountriesList(limit, offset)
                .subscribe(next -> {
                    if (next != null) {
                        // todo
                        view.showError(next.getAsString());
                    }
                }, err -> view.showError(err.getMessage()), () -> {});
    }

    @Override
    public void doGetStates(Integer countryId, Integer limit, Integer offset) {
        interactor.toDoGetRegionsList(countryId, limit, offset)
                .subscribe(next -> {
                    if (next != null) {
                        // todo
                        view.showError(next.getAsString());
                    }
                }, err -> view.showError(err.getMessage()), () -> {});
    }

    @Override
    public void doGetCities(Integer stateId, Integer limit, Integer offset) {
        interactor.toDoGetCitiesList(stateId, limit, offset)
                .subscribe(next -> {
                    if (next != null) {
                        // todo
                        view.showError(next.getAsString());
                    }
                }, err -> view.showError(err.getMessage()), () -> {});
    }
}
