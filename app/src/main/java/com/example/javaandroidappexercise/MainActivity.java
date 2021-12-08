package com.example.javaandroidappexercise;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import com.example.javaandroidappexercise.FetchRewardsList;
import com.example.javaandroidappexercise.GetFetchRewardsService;
import com.example.javaandroidappexercise.RetroFitInstance;

public class MainActivity extends AppCompatActivity {

    private ListView frListView;
    private ArrayAdapter<FetchRewardsList> frListAdapter;
    private List<FetchRewardsList> all_values; //show all
    private List<FetchRewardsList> filter_values; //show only filtered

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        frListView = (ListView) findViewById(android.R.id.list);
        frListAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, new LinkedList<FetchRewardsList>());
        frListView.setAdapter(frListAdapter);
    }

    public void getLists(View view) {
        frListAdapter.clear();
        frListAdapter.notifyDataSetChanged();

        //make http call to the api service and display the list
        GetFetchRewardsService service = RetroFitInstance.getRetroFitInstance().create(GetFetchRewardsService.class);
        Call<List<FetchRewardsList>> call = service.getAllLists();
        call.enqueue(new Callback<List<FetchRewardsList>>() {
            @Override
            public void onResponse(Call<List<FetchRewardsList>> call, Response<List<FetchRewardsList>> response) {
                List<FetchRewardsList> frlist = response.body();
                for (FetchRewardsList f: frlist) {
                    Log.d("listId", f.getListId()); //sort results by listId first then name
                    Log.d("name", f.getName());
                    Log.d("id", f.getId());
                }
            }

            @Override
            public void onFailure(Call<List<FetchRewardsList>> call, Throwable t) {
                Log.d("Error", t.getMessage());
            }
        });
    }

    //Filter By ListId
    public void filterListId(List<FetchRewardsList> frlist) {
        for (FetchRewardsList list: all_values) {
            if (list.listId != null) {
                Log.d("listid", list.getListId());
            }
            else {
            }
        }
    }

    //Filter Names that Are Blank/Null
    public void filterNames(FetchRewardsList name) {
        filter_values = new <ArrayList>(all_values);
        filter_values.removeAll(Arrays.asList("", null));
    }

}