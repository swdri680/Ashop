package seh.example.com.ashop;

import android.app.Dialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONObject;

import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends AppCompatActivity {
    EditText id, pw;
    String jsontext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Dialog loginDialog = new Dialog(this);
        loginDialog.setContentView(R.layout.logindialog);
        loginDialog.setTitle(R.string.login);
        loginDialog.setCancelable(false);

        Button btLogin = (Button) loginDialog.findViewById(R.id.btLogin);

        id = (EditText) loginDialog.findViewById(R.id.editId);
        pw = (EditText) loginDialog.findViewById(R.id.editPW);

        loginDialog.show();
    }

    public void btManager(View v){
        int viewId = v.getId();
        String loginId, loginPw;
        URL url = null;
        HttpURLConnection con = null;
        StringBuilder sb = new StringBuilder();

        switch (viewId){
            case R.id.btLogin :
                loginId = id.getText().toString();
                loginPw = pw.getText().toString();

                try {
                    url = new URL("http://203.233.196.207:8888/ProjectOctober/loginMobile.action?email="+loginId+"&password="+loginPw);
                } catch (MalformedURLException e) {
                    Toast.makeText(this, "잘못된 URL입니다.", Toast.LENGTH_SHORT).show();
                }

                try {
                    con = (HttpURLConnection) url.openConnection();

                    if (con != null) {
                        con.setConnectTimeout(10000);	//연결제한시간. 0은 무한대기.
                        con.setUseCaches(false);		//캐쉬 사용여부

                        if (con.getResponseCode() == HttpURLConnection.HTTP_OK) {

                            InputStreamReader in = new InputStreamReader(con.getInputStream());
                            int ch;
                            while ((ch = in.read()) != -1) {
                                sb.append((char) ch);
                            }
                            in.close();

                            jsontext = sb.toString();

                            if (jsontext == null) {
                                Toast.makeText(MainActivity.this, "로그인 에러", Toast.LENGTH_SHORT).show();
                                return;
                            }

                            JSONObject json = null;
                            json = new JSONObject(jsontext);
                            Member member = (Member) json.get("member");

                            if(member.getMemCode()==2){

                            }else{
                                Toast.makeText(MainActivity.this, "일반 고객만 이요할 수 있습니다", Toast.LENGTH_SHORT).show();
                                return;
                            }

                        }
                    }
                }
                catch (Exception e) {
                    Toast.makeText(this, "" + e.toString(), Toast.LENGTH_SHORT).show();
                }

                break;
        }

    }
}
