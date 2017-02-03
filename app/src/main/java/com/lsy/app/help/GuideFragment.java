package com.lsy.app.help;

import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.BinderThread;
import android.support.annotation.Nullable;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;

/**
 * Created by Administrator on 2016/5/11.
 */
public class GuideFragment extends DialogFragment implements View.OnClickListener, DialogInterface.OnKeyListener{
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        this.getDialog().setOnKeyListener(this);
        Util.printLog("GuideFragment onCreateView被调用");
        View view = inflater.inflate(R.layout.guide, container, false);
        ImageButton btnCloseGuide = (ImageButton)view.findViewById(R.id.btn_close_guide);
        btnCloseGuide.setOnClickListener(this);
        Button btnTell = (Button)view.findViewById(R.id.btn_tell);
        btnTell.setOnClickListener(this);
        Button btnMark = (Button)view.findViewById(R.id.btn_good_mark);
        btnMark.setOnClickListener(this);
        return view;
    }

    @Override
    public boolean onKey(DialogInterface dialog, int keyCode, KeyEvent event) {
        if(getActivity() instanceof guideOnClick && keyCode == KeyEvent.KEYCODE_BACK){
            ((guideOnClick) getActivity()).keyDownOnClick();
        }
        return true;
    }

    public interface guideOnClick{
        void guideCloseOnClick();
        void keyDownOnClick();
        void goodMarkOnClick();
        void tellMeOnClick();
    }
    @Override
    public void onClick(View v) {
        if(getActivity() instanceof guideOnClick)
        {
            switch (v.getId()){
                case R.id.btn_close_guide:
                ((guideOnClick) getActivity()).guideCloseOnClick();
                    break;
                case R.id.btn_tell:
                    ((guideOnClick) getActivity()).tellMeOnClick();
                    break;
                case R.id.btn_good_mark:
                    ((guideOnClick) getActivity()).goodMarkOnClick();
                    break;
                default:
                    break;
            }
        }
    }
}
