package com.mredrock.date.config;

import android.content.Context;
import android.support.annotation.IdRes;
import android.support.annotation.LayoutRes;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mredrock.date.R;

/**
 * Created by Mr.Jude on 2015/4/22.
 */
public abstract class BaseActivityVu implements IVu{
    private Context context;
    private LayoutInflater inflater;
    private Toolbar toolbar;
    protected View rootView;

    @Override
    public final void init(LayoutInflater inflater, ViewGroup container) {
        this.inflater = inflater;
        context = inflater.getContext();
        OnCreate();
    }
    protected abstract void OnCreate();

    protected final void setContentView(View view){
        rootView = view;
        initToolBar();
    };

    protected final void setContentView(@LayoutRes int res){
        rootView = inflater.inflate(res,null);
        initToolBar();
    };

    protected final <E extends View> E $(View view,@IdRes int id){
        return (E)view.findViewById(id);
    }
    protected final <E extends View> E $(@IdRes int id){
        return (E)rootView.findViewById(id);
    }

    private final void initToolBar(){
        toolbar = $(rootView,R.id.toolbar);
        ActionBarActivity act = (ActionBarActivity)context;
        if (toolbar!=null){
            act.setSupportActionBar(toolbar);
            act.getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
        onToolBarInit(act,toolbar);
    }

    protected void onToolBarInit(ActionBarActivity act,Toolbar toolbar){
    }

    @Override
    public View getView() {
        return rootView;
    }

    protected final Context getContext() {
        return context;
    }

    protected final LayoutInflater getInflater() {
        return inflater;
    }

    protected final Toolbar getToolbar() {
        return toolbar;
    }

}