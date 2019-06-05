package com.example.jobschedulerrsr;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.net.Network;
import android.net.NetworkRequest;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    JobScheduler js;
    JobInfo.Builder ji;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        js= (JobScheduler) getSystemService(JOB_SCHEDULER_SERVICE);
    }


    public void start(View view) {
        ji=new JobInfo.Builder(1,new ComponentName(getPackageName(),MyJobService.class.getName()));
        ji.setRequiredNetworkType(JobInfo.NETWORK_TYPE_ANY);
        ji.setRequiresCharging(true);
        JobInfo jobInfo=ji.build();
        js.schedule(jobInfo);
    }
}
