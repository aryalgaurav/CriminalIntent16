package android.nku.edu.criminalintent;

import android.support.v4.app.Fragment;

/**
 * Created by Gaurav on 8/16/2016.
 */
public class CrimeListActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment() {
        return new CrimeListFragment();
    }
}
