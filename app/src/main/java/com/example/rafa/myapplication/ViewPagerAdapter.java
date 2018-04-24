package com.example.rafa.myapplication;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by Rafa on 05/04/2018.
 */

class ViewPagerAdapter extends FragmentPagerAdapter{
    private static int NUM_ITEMS = 3;

    public ViewPagerAdapter(FragmentManager fragmentManager){
        super(fragmentManager);
    }

    @Override
    public Fragment getItem(int position) {
        switch(position){
            case 0: return HomeFragment.newInstance(0,"Inicio");
            case 1: return FavoritosFragment.newInstance(1,"Favoritos");
            case 2: return MiCuentaFragment.newInstance(2,"Mi Cuenta");
            default: return null;
        }
    }

    @Override
    public int getCount() {
        return NUM_ITEMS;
    }

    @Override
    public CharSequence getPageTitle(int position){
        switch(position){
            case 0: return "Inicio";
            case 1: return "Favoritos";
            case 2: return "Mi Cuenta";
            default: return null;
        }
    }
}
