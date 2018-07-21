package io.github.superbderrick.scoreboard.theme;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import io.github.superbderrick.scoreboard.R;
import io.github.superbderrick.scoreboard.activities.MainActivity;
import io.github.superbderrick.scoreboard.ui.TouchLayout;

/**
 * Created by derrick on 03/06/2018.
 */

public class ThemeOperator {

    private static final String LOG_TAG = "ThemeOperator";

    private Context mContext = null;
    private Theme mCurrentGameTheme;

    private EditText mLeftUserEditText , mRightUserEditText;

    private TextView mLeftScoreTextView,mRightScoreTextView,mLeftSetScoreTextView,mRightSetScoreTextView;

    private TouchLayout mLeftUpperTouchView , mLeftBottomTouchView , mRightUpperTouchView ,  mRightBottomTouchView;

    private RelativeLayout mLeftCenterBar , mRightCenterBar;

    private View mCenterBar;

    public ThemeOperator(int themeStyle , Context context) {
        init(themeStyle , context);
    }

    private void init(int theme , Context context) {

        mCurrentGameTheme = ThemeFactory.getTheme(theme);

        mContext = context;

        setupViews(mCurrentGameTheme);
    }

    private void setupViews(Theme theme) {

        //for User EditText
        mLeftUserEditText = ((MainActivity) mContext).findViewById(R.id.leftUserName);
        mRightUserEditText = ((MainActivity) mContext).findViewById(R.id.rightUserEdit);

        //for Score Color
        mLeftScoreTextView = ((MainActivity) mContext).findViewById(R.id.leftScoreTextview);
        mRightScoreTextView = ((MainActivity) mContext).findViewById(R.id.rightScoreTextview);

        //for SetScore Color
        mLeftSetScoreTextView = ((MainActivity) mContext).findViewById(R.id.leftSetScoreTextview);
        mRightSetScoreTextView = ((MainActivity) mContext).findViewById(R.id.rightsetscoretextview);

        mCenterBar = ((MainActivity) mContext).findViewById(R.id.middleView);

        mLeftUpperTouchView =((MainActivity) mContext).findViewById(R.id.leftUpperTouchView);

        mLeftBottomTouchView =((MainActivity) mContext).findViewById(R.id.leftBottomTouchView);


        mRightUpperTouchView = ((MainActivity) mContext).findViewById(R.id.rightUpperTouchView);
        mRightBottomTouchView =((MainActivity) mContext).findViewById(R.id.rightBottomTouchView);

        mLeftCenterBar = ((MainActivity) mContext).findViewById(R.id.leftBar);
        mRightCenterBar = ((MainActivity) mContext).findViewById(R.id.rightbar);
    }

    public void applyTheme() {

        mLeftUserEditText.setBackgroundColor(mCurrentGameTheme.mUserNameColor);
        mRightUserEditText.setBackgroundColor(mCurrentGameTheme.mUserNameColor);

        //setup for bottom line background color for center point
        setupForMiddlePart();

        //setup for bottom line background color for setscore
        setupForBottomLine();
    }

    private void setupForBottomLine() {
        mLeftSetScoreTextView.setTextColor(mCurrentGameTheme.mSetScoreTextColor);
        mRightSetScoreTextView.setTextColor(mCurrentGameTheme.mSetScoreTextColor);
        mLeftSetScoreTextView.setBackgroundColor(mCurrentGameTheme.mSetScoreBackGroundColor);
        mRightSetScoreTextView.setBackgroundColor(mCurrentGameTheme.mSetScoreBackGroundColor);
    }

    private void setupForMiddlePart() {
        mLeftScoreTextView.setTextColor(mCurrentGameTheme.mJustScoreTextColor);
        mRightScoreTextView.setTextColor(mCurrentGameTheme.mJustScoreTextColor);
        mLeftUpperTouchView.setDefaultBackgroundColor(mCurrentGameTheme.mJustScoreBackgroundColorString);
        mLeftBottomTouchView.setDefaultBackgroundColor(mCurrentGameTheme.mJustScoreBackgroundColorString);
        mRightUpperTouchView.setDefaultBackgroundColor(mCurrentGameTheme.mJustScoreBackgroundColorString);
        mRightBottomTouchView.setDefaultBackgroundColor(mCurrentGameTheme.mJustScoreBackgroundColorString);
        mLeftUpperTouchView.setTouchedBackgroundColor(mCurrentGameTheme.mJustScoreTouchBackgroundColorString);
        mLeftBottomTouchView.setTouchedBackgroundColor(mCurrentGameTheme.mJustScoreTouchBackgroundColorString);
        mRightUpperTouchView.setTouchedBackgroundColor(mCurrentGameTheme.mJustScoreTouchBackgroundColorString);
        mRightBottomTouchView.setTouchedBackgroundColor(mCurrentGameTheme.mJustScoreTouchBackgroundColorString);
        mLeftCenterBar.setBackgroundColor(mCurrentGameTheme.mBarColor);
        mRightCenterBar.setBackgroundColor(mCurrentGameTheme.mBarColor);
    }

}

 class ThemeFactory {
    public static Theme getTheme(int gameTheme) {

        if(gameTheme > 0) {
            return new LightTheme();
        } else {
            return new DarkTheme();
        }
    }
}
