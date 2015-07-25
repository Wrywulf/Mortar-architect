package architect.commons.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import java.util.Arrays;
import java.util.List;

import architect.ScreenPath;
import architect.StackFactory;
import mortar.MortarScope;

/**
 * @author Lukasz Piliszczuk - lukasz.pili@gmail.com
 */
public class StackablePagerAdapter extends PagerAdapter {

    private final Context context;
    private final List<ScreenPath> paths;

    public StackablePagerAdapter(Context context, ScreenPath... paths) {
        this(context, Arrays.asList(paths));
    }

    public StackablePagerAdapter(Context context, List<ScreenPath> paths) {
        this.context = context;
        this.paths = paths;
    }

    @Override
    public int getCount() {
        return paths.size();
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        ScreenPath path = paths.get(position);

        Context pageContext = StackFactory.createContext(context, path, String.valueOf(position));
        View newChild = path.createView(pageContext, container);
        container.addView(newChild);
        return newChild;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        View view = ((View) object);
        MortarScope scope = MortarScope.getScope(view.getContext());
        container.removeView(view);
        scope.destroy();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view.equals(object);
    }
}
