package com.example.administrator.hg;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.concurrent.TimeUnit;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.examples.helloworld.GreeterGrpc;
import io.grpc.examples.helloworld.LoginReply;
import io.grpc.examples.helloworld.LoginRequest;


/**
 * Created by Administrator on 2017/10/16.
 */

public class LoginActivity extends AppCompatActivity {

    private String username="su";
    private String userpass="123";
    private String usernameInfo;
    private String passwordInfo;

    private Button dl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_login);

        final TextView usernameview = (TextView) findViewById(R.id.login_username);
        final TextView passwordview = (TextView) findViewById(R.id.login_password);
        Button dl = (Button) findViewById(R.id.dl);
        dl.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                String inputname= usernameview.getText().toString().trim();
                String inputpassword=passwordview.getText().toString().trim();
              //  Boolean dl = HelloWorldClient("10.0.2.2",50051,inputname,inputpassword);
                if (inputname.isEmpty() || inputpassword.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "用户名和密码不能为空",
                            Toast.LENGTH_SHORT).show();
                    return;
                }
                Intent intent = new Intent(LoginActivity.this, ZhuyeActivity.class);
                startActivity(intent);
            }


        });
    }
    private ManagedChannel channel;
    private GreeterGrpc.GreeterBlockingStub blockingStub;

    /** Construct client connecting to HelloWorld server at {@code host:port}. */
    public Boolean HelloWorldClient(String host, int port,String name,String password)
    {

        try {
            channel = ManagedChannelBuilder.forAddress(host, port)
                    .usePlaintext(true)
                    .build();
            blockingStub = GreeterGrpc.newBlockingStub(channel);
            LoginRequest request = LoginRequest.newBuilder().setName(name).setPassword
                    (password).build();
            LoginReply response = blockingStub.logon(request);
            System.out.println(response.getMessage()+"fuck u");
            if(response.getMessage().equals("yes")){
                return true;
            }else {
                return false;
            }
        }catch (Exception e){
            return false;
        }

    }

    public void shutdown() throws InterruptedException {
        channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
    }

    /** Say hello to server. */


    /**
     * Greet server. If provided, the first element of {@code args} is the name to use
     in the
     * greeting.
     */

}
