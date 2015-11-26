package com.clayons.interviewquestions.adapaters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.clayons.interviewquestions.Model.Person;
import com.clayons.interviewquestions.R;

import java.util.List;

/**
 * Created by Nitin on 11/26/2015.
 */
public class PersonAdapter extends RecyclerView.Adapter<PersonAdapter.PersonViewHolder> {


    List<Person> mPerson;
    Context mContext;
    LayoutInflater inflater;
    MyClickListener myClickListener;

    public PersonAdapter(Context context, List<Person> persons, MyClickListener mClickListener) {
        mContext = context;
        mPerson = persons;
        inflater = LayoutInflater.from(mContext);
        myClickListener = (MyClickListener) mContext;
    }

    @Override
    public PersonViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new PersonViewHolder(inflater.inflate(R.layout.person_list_item, parent, false));
    }

    @Override
    public void onBindViewHolder(PersonViewHolder holder, int position) {

        holder.personNameTextView.setText(mPerson.get(position).getFirstName() + " " + mPerson.get(position).getLastName());
        if (mPerson.get(position).getLiked()) {
            holder.personNameTextView.setBackgroundColor(mContext.getResources().getColor(android.R.color.holo_blue_dark));
        } else
            holder.personNameTextView.setBackgroundColor(mContext.getResources().getColor(position % 2 == 0 ? android.R.color.white : android.R.color.black));
    }

    @Override
    public int getItemCount() {
        return mPerson.size();
    }

    public interface MyClickListener {
        void clickedPositin(int position);
    }

    public class PersonViewHolder extends RecyclerView.ViewHolder {

        TextView personNameTextView;

        public PersonViewHolder(View itemView) {
            super(itemView);
            personNameTextView = (TextView) itemView.findViewById(R.id.personName);
            personNameTextView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    /*Intent mDetailActivityIntent = new Intent(mContext, DetailActivity.class);
                    */
                    myClickListener.clickedPositin(getAdapterPosition());
                    //mDetailActivityIntent.putExtra("data", mPersonData);
                    //mContext.startActivity(new Intent(mContext, DetailActivity.class));
                }
            });

        }
    }
}
