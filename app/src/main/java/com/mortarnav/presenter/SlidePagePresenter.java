//package com.mortarnav.presenter;
//
//import android.os.Bundle;
//
//import com.mortarnav.DaggerScope;
//import com.mortarnav.deps.RestClient;
//import com.mortarnav.deps.UserManager;
//import com.mortarnav.deps.WithAppDependencies;
//import com.mortarnav.view.SlidePageView;
//
//import architect.robot.AutoStackable;
//import architect.robot.FromPath;
//import autodagger.AutoComponent;
//import mortar.ViewPresenter;
//
///**
// * @author Lukasz Piliszczuk - lukasz.pili@gmail.com
// */
//@AutoStackable(
//        component = @AutoComponent(
//                dependencies = SlidesPresenter.class,
//                superinterfaces = WithAppDependencies.class),
//        pathWithView = SlidePageView.class
//)
//@DaggerScope(SlidePagePresenter.class)
//public class SlidePagePresenter extends ViewPresenter<SlidePageView> {
//
//    private final int id;
//
//    // some dependencies provided by dagger
//    private final RestClient restClient;
//    private final UserManager userManager;
//
//    public SlidePagePresenter(@FromPath int id, RestClient restClient, UserManager userManager) {
//        this.id = id;
//        this.restClient = restClient;
//        this.userManager = userManager;
//    }
//
//    @Override
//    protected void onLoad(Bundle savedInstanceState) {
//        String title;
//        int color;
//        switch (id) {
//            case 1:
//                title = "Page One";
//                color = android.R.color.holo_blue_bright;
//                break;
//            case 2:
//                title = "Page Two";
//                color = android.R.color.holo_orange_dark;
//                break;
//            case 3:
//            default:
//                title = "Page Three";
//                color = android.R.color.holo_red_dark;
//                break;
//        }
//
//        getView().textView.setText(title);
//        getView().setBackgroundColor(getView().getResources().getColor(color));
//    }
//}
