package discoverthis.xyz.discover2;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import android.widget.ArrayAdapter;

public class MainActivity extends AppCompatActivity {

    private ArrayList<String> data = new ArrayList<String>();
    MyListAdapter listAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ListView listView = (ListView) findViewById(R.id.listview);
    }

    public class MyListAdapter extends ArrayAdapter<String>{
        private int layout;
        public MyListAdapter(Context context, int resource, List<String> objects){
            super(context, resource, objects);
            layout = resource;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent){
            ViewHolder mainViewHolder = null;

            if(convertView == null){
                LayoutInflater inflater = LayoutInflater.from(getContext());
                convertView = inflater.inflate(layout,parent,false);
                ViewHolder viewHolder = new ViewHolder();
                viewHolder.findFriend = (Button) convertView.findViewById(R.id.list_item_ask_friend_button);
                viewHolder.friendName = (TextView) convertView.findViewById(R.id.list_item_friend_name);
                viewHolder.friendName.setText("Ash Ketchum");
            } else {
                mainViewHolder = (ViewHolder) convertView.getTag();
            }

            return convertView;
        }
    }

    public class ViewHolder{
        TextView friendName;
        Button findFriend;
    }
}
