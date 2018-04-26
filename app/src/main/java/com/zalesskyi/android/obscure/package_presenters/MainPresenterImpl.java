package com.zalesskyi.android.obscure.package_presenters;

import android.content.Intent;
import android.util.Log;

import com.zalesskyi.android.obscure.model.Event;
import com.zalesskyi.android.obscure.model.Owner;
import com.zalesskyi.android.obscure.model.Place;
import com.zalesskyi.android.obscure.realm.IRealmService;
import com.zalesskyi.android.obscure.realm.RealmServiceImpl;
import com.zalesskyi.android.obscure.realm.User;
import com.zalesskyi.android.obscure.view.IBaseView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Алексей on 20.04.2018.
 */

public class MainPresenterImpl extends BasePresenter<IBaseView.IMainView>
        implements IPresenterContract.IMainPresenter {

    /*public MainPresenterImpl(Application application, IInteractorContract interactor,
                             IValidator validator, INetworkCheck networkCheck, IRealmService realmService) {
        this.application = application;
        this.interactor = interactor;
        this.validator = validator;
        this.networkCheck = networkCheck;
        this.realmService = realmService;
    }*/

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
    public void onActivityResult(int requestCode, int resultCode, Intent data) {

    }

    @Override
    public void init(IBaseView.IMainView view) {
        super.init(view);
    }

    @Override
    public void dismiss() {
        super.dismiss();
    }


    private void getMoc() {
        List<Event> events = new ArrayList<>();

        Place place1 = new Place(application, 41.001840, 28.929834);
        Place place2 = new Place(application, 42.958805, 62.117283);
        Place place3 = new Place(application, 49.964020, 8.592401);
        Place place4 = new Place(application, 53.675864, 23.806594);
        Place place5 = new Place(application, 60.762876, 10.252082);
        Place place6 = new Place(application, 46.740328, 110.398543);
        Place place7 = new Place(application, 54.799057, 32.063126);
        Place place8 = new Place(application, -19.464994, 17.697311);
        Place place9 = new Place(application, 52.193635, 0.736614);
        Place place10 = new Place(application, 20.221067, 77.073060);
        Place place11 = new Place(application, 51.048673, -107.381090);
        Place place12 = new Place(application, 34.511300, -105.174314);
        Place place13 = new Place(application, -7.345948, -62.608199);
        Place place14 = new Place(application, -31.499167, -65.381019);
        Place place15 = new Place(application, -23.500195, 149.648047);
        Place place16 = new Place(application, 37.317084, 91.637350);
        Place place17 = new Place(application, 26.364976, 43.361036);
        Place place18 = new Place(application, 39.634548, 21.418667);
        Place place19 = new Place(application, 33.908921, -0.164310);
        Place place20 = new Place(application, 38.478650, 140.427034);

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

        event.setOwner(user2);
        event.setPlace(place2);

        events.add(event);

        event.setOwner(user3);
        event.setPlace(place3);

        events.add(event);

        event.setOwner(user4);
        event.setPlace(place4);

        events.add(event);

        event.setOwner(user5);
        event.setPlace(place5);

        events.add(event);

        event.setOwner(user6);
        event.setPlace(place6);

        events.add(event);

        event.setOwner(user7);
        event.setPlace(place7);

        events.add(event);

        event.setOwner(user8);
        event.setPlace(place8);

        events.add(event);

        event.setOwner(user9);
        event.setPlace(place9);

        events.add(event);

        event.setOwner(user10);
        event.setPlace(place10);

        events.add(event);

        event.setOwner(user11);
        event.setPlace(place11);

        events.add(event);

        event.setOwner(user12);
        event.setPlace(place12);

        events.add(event);

        event.setOwner(user13);
        event.setPlace(place13);

        events.add(event);

        event.setOwner(user14);
        event.setPlace(place14);

        events.add(event);

        event.setOwner(user15);
        event.setPlace(place15);

        events.add(event);

        event.setOwner(user16);
        event.setPlace(place16);

        events.add(event);

        event.setOwner(user17);
        event.setPlace(place17);

        events.add(event);

        event.setOwner(user18);
        event.setPlace(place18);

        events.add(event);

        event.setOwner(user19);
        event.setPlace(place19);

        events.add(event);

        event.setOwner(user20);
        event.setPlace(place20);

        events.add(event);

        Random rand = new Random();
        for (Event e : events) {
            e.setId(rand.nextInt(100000000));
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
