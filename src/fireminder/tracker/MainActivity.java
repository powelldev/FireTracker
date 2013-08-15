package fireminder.tracker;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity implements OnClickListener {

	/** Text View controlling user 1's hp */
	private static TextView hp_tv;
	/** Text View controlling user 2's hp */
	private static TextView hp_tv2;
	/** Button that adds to user 1's hp */
	private Button plus_btn;
	/** Button that adds to user 2's hp */
	private Button plus_btn2;
	/** Button that subtracts from user 1's hp */
	private Button minus_btn;
	/** Button that subtracts from user 2's hp */
	private Button minus_btn2;

	private final static String DEFAULT_HP = "20";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.user_view);
		initUI();

	}

	/** Assigns view id */
	private void initUI() {
		hp_tv = (TextView) findViewById(R.id.hp);
		hp_tv2 = (TextView) findViewById(R.id.hp2);
		plus_btn = (Button) findViewById(R.id.plus_btn);
		plus_btn2 = (Button) findViewById(R.id.plus_btn2);
		minus_btn = (Button) findViewById(R.id.minus_btn);
		minus_btn2 = (Button) findViewById(R.id.minus_btn2);
		
		// TODO get defaultHp from shared preferences
		String defaultHp = null;

		if(defaultHp == null){
			defaultHp = DEFAULT_HP;
		}
		
		hp_tv.setText(defaultHp);
		hp_tv2.setText(defaultHp);
		
		plus_btn.setOnClickListener(this);
		plus_btn2.setOnClickListener(this);
		minus_btn.setOnClickListener(this);
		minus_btn2.setOnClickListener(this);
		
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.plus_btn:
			incrementHp(hp_tv);
			break;
		case R.id.plus_btn2:
			incrementHp(hp_tv2);
			break;
		case R.id.minus_btn:
			decrementHp(hp_tv);
			break;
		case R.id.minus_btn2:
			decrementHp(hp_tv2);
			break;
		}
	}

	/** Adds 1 to the TextView passed to it */
	private void incrementHp(TextView hp_tv) {
		int mHp = Integer.parseInt(hp_tv.getText().toString());
		mHp++;
		hp_tv.setText("" + mHp);
	}

	/** Subs 1 to the TextView passed to it.*/
	private void decrementHp(TextView hp_tv) {
		int mHp = Integer.parseInt(hp_tv.getText().toString());
		mHp--;
		hp_tv.setText("" + mHp);
	}
}
