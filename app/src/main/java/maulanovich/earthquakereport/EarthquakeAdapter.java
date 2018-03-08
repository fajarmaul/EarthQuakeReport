package maulanovich.earthquakereport;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by Maulanovich on 06/03/2018.
 */

public class EarthquakeAdapter extends ArrayAdapter<Earthquake> {

    public EarthquakeAdapter(Context context, List<Earthquake> earthquakes){
        super(context, 0, earthquakes);

    }

    private String formatDate(Date dateObject){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("LLL dd, yyyy");
        String dateFormat = simpleDateFormat.format(dateObject);
        return dateFormat;
    }

    private String formatTime(Date dateObject){
        SimpleDateFormat simpleTimeFormat = new SimpleDateFormat("H:mm a");
        String timeFormat = simpleTimeFormat.format(dateObject);
        return timeFormat;
    }

    private String checkFirstString(String inputString){
        String string1;
        String check = "of";
        if(inputString.contains(check)){
            string1 = inputString.substring(0, inputString.indexOf(check)+2);
        }
        else{
            string1 = "Near Of";
        }
        return string1;
    }

    private String checkSecondString(String inputString){
        String string1;
        String check = "of";
        if(inputString.contains(check)){
            string1 = inputString.substring(inputString.indexOf(check)+check.length(), inputString.length());
        }
        else{
            string1 = inputString;
        }
        return string1;
    }

    private int getMagnitudeColor(double nMagnitude){
        int magnitudeColorResourceId;
        int magnitudeFloor = (int) Math.floor(nMagnitude);
        switch (magnitudeFloor){
            case 0:
            case 1:
                magnitudeColorResourceId = R.color.magnitude1;
                break;
            case 2:
                magnitudeColorResourceId = R.color.magnitude2;
                break;
            case 3:
                magnitudeColorResourceId = R.color.magnitude3;
                break;
            case 4:
                magnitudeColorResourceId = R.color.magnitude4;
                break;
            case 5:
                magnitudeColorResourceId = R.color.magnitude5;
                break;
            case 6:
                magnitudeColorResourceId = R.color.magnitude6;
                break;
            case 7:
                magnitudeColorResourceId = R.color.magnitude7;
                break;
            case 8:
                magnitudeColorResourceId = R.color.magnitude8;
                break;
            case 9:
                magnitudeColorResourceId = R.color.magnitude9;
                break;
            default:
                magnitudeColorResourceId = R.color.magnitude10plus;
                break;
        }
        return ContextCompat.getColor(getContext(), magnitudeColorResourceId);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        View listItemView = convertView;
        if (listItemView == null){
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.earthquake_list_item, parent, false);
        }



        Earthquake currentEarthquake = getItem(position);
        TextView magnitudeView = (TextView) listItemView.findViewById(R.id.magnitude);
        TextView locationView = (TextView) listItemView.findViewById(R.id.location);
        TextView secondaryLocationView = (TextView) listItemView.findViewById(R.id.location_secondary);
        TextView dateView = (TextView) listItemView.findViewById(R.id.date);
        TextView timeView = (TextView) listItemView.findViewById(R.id.time);

        GradientDrawable magnitudeCircle = (GradientDrawable) magnitudeView.getBackground();
        int magnitudeColor = getMagnitudeColor(currentEarthquake.getnMagnitude());
        magnitudeCircle.setColor(magnitudeColor);

        String stringRaw = currentEarthquake.getnLocation();
        String string1 = this.checkFirstString(stringRaw);
        String string2 = this.checkSecondString(stringRaw);
        //Date Formatter
        Date dateObject = new Date(currentEarthquake.getnTimeinMilisec());
        String formattedDate = formatDate(dateObject);

        Date timeObject = new Date(currentEarthquake.getnTimeinMilisec());
        String formattedTime = formatTime(timeObject);

        //Magnitude Formatter
        double magnitudeRaw = currentEarthquake.getnMagnitude();
        DecimalFormat magnitudeFormat = new DecimalFormat("0.0");
        String magnitudeResult = magnitudeFormat.format(magnitudeRaw);

        magnitudeView.setText(magnitudeResult);
        locationView.setText(string2);
        secondaryLocationView.setText(string1);
        dateView.setText(formattedDate);
        timeView.setText(formattedTime);

        return listItemView;
    }


}
