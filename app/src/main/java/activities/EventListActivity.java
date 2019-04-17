package activities;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mentor.R;
import com.github.sundeepk.compactcalendarview.CompactCalendarView;
import com.github.sundeepk.compactcalendarview.domain.Event;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class EventListActivity extends AppCompatActivity implements CompactCalendarView.CompactCalendarViewListener {

    private CompactCalendarView compactCalendarView;
    private SimpleDateFormat simpleDateFormat;
    private Context context;
    private TextView textView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_list);


        textView = (TextView) findViewById(R.id.event_list_textView);
        simpleDateFormat = new SimpleDateFormat("MMMM - yyyy", Locale.getDefault());
        context = getApplicationContext();

        onMonthScroll(new Date());

        compactCalendarView = (CompactCalendarView) findViewById(R.id.eventList_compactCalender);
        compactCalendarView.setUseThreeLetterAbbreviation(true);

        Event event = new Event(R.color.colorMainGreenDark, 1555522107000L, "Event");
        compactCalendarView.addEvent(event);

        compactCalendarView.setListener(this);

    }

    @Override
    public void onDayClick(Date dateClicked) {
        if (dateClicked.toString().compareTo("Wed Apr 17 00:00:00 GMT+03:00 2019") == 0) {
            Toast.makeText(context, "Teachers' Professional Day", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(context, "No Events Planned for that day", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onMonthScroll(Date firstDayOfNewMonth) {
        textView.setText(simpleDateFormat.format(firstDayOfNewMonth));
    }
}
