package com.tess.futrash.view.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.tess.futrash.R;
import com.tess.futrash.model.pojo_all_item.AllItemRespon;
import com.tess.futrash.model.pojo_all_item.Content;
import com.tess.futrash.model.pojo_all_item.User;
import com.tess.futrash.servis.MethodsFactory;
import com.tess.futrash.servis.RetrofitHandle;
import com.tess.futrash.shared_pref.SpHandle;
import com.tess.futrash.view.adapter.AdapterAllItemFood;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link LandingPageFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class LandingPageFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private RecyclerView recyclerView;
    private AdapterAllItemFood adapterAllItemFood;
    private List<Content> contentList = new ArrayList<>();
    private MethodsFactory methodsFactory;
    private SpHandle spHandle;

    public LandingPageFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment LandingPageFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static LandingPageFragment newInstance(String param1, String param2) {
        LandingPageFragment fragment = new LandingPageFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_landing_page, container, false);

        spHandle = new SpHandle(getContext());

        recyclerView = view.findViewById(R.id.rv_all_items);
        adapterAllItemFood = new AdapterAllItemFood( getContext(),contentList);
        recyclerView.setAdapter(adapterAllItemFood);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(linearLayoutManager);

        getItemList();

        return view;

    }

    public void getItemList(){
        Long id = spHandle.getSpIdUser();

        String tokenUser = spHandle.getSpTokenUser();
        Map<String,String> token = new HashMap<>();
        token.put("Authorization", "Bearer "+tokenUser);


        methodsFactory = RetrofitHandle.getRetrofitLink().create(MethodsFactory.class);
        Call<AllItemRespon> allItemResponCall =methodsFactory.getAllItem(token);
        allItemResponCall.enqueue(new Callback<AllItemRespon>() {
            @Override
            public void onResponse(Call<AllItemRespon> call, Response<AllItemRespon> response) {

                if (response.isSuccessful()) {
                    // response.body().getData();
                    List<Content> content = response.body().getContent();
                   // List<User> users= (List<User>) response.body();
                   // spHandle.setIdMitraItem(SpHandle.SP_ID_MITRA_ITEM, users.get(0).getId());

                    adapterAllItemFood = new AdapterAllItemFood(getContext(),content);
                    recyclerView.setAdapter(adapterAllItemFood);
                    //adapterIndonesia = new AdapterIndonesia(getContext(),propinsiAtributes);
                    //recyclerView.setAdapter(adapterIndonesia);
                    adapterAllItemFood.notifyDataSetChanged();
                }
                else {
                    // error case
                    switch (response.code()) {
                        case 404:
                            Toast.makeText(getContext(), "404 not found", Toast.LENGTH_SHORT).show();
                            break;
                        case 500:
                            Toast.makeText(getContext(), "500 internal server error", Toast.LENGTH_SHORT).show();
                            break;
                        case 401:
                            Toast.makeText(getContext(), "401 unauthorized", Toast.LENGTH_SHORT).show();
                            break;

                        default:
                            Toast.makeText(getContext(), "unknown error", Toast.LENGTH_SHORT).show();
                            break;
                    }
                }
            }

            @Override
            public void onFailure(Call<AllItemRespon> call, Throwable t) {
                Toast.makeText(getContext(), "network failure :( inform the user and possibly retry ", Toast.LENGTH_SHORT).show();

            }
        });


    }

}