<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".MainActivity"
    android:orientation="vertical"
    >

    <TextView
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:text="Signup Activity"
        android:textAlignment="center"
        android:textColor="@color/purple_500"
        android:textSize="30sp"
        android:textStyle="bold"
        />

    <EditText
        android:id="@+id/uid"
        android:layout_width="match_parent"
        android:layout_height="62dp"
        android:ems="10"
        android:hint="Enter the Used ID"
        android:textAlignment="center"
        android:textSize="20sp" />

    <EditText
        android:id="@+id/pwd"
        android:layout_width="match_parent"
        android:layout_height="68dp"
        android:ems="10"
        android:hint="Enter the Password"
        android:inputType="textPassword"
        android:textAlignment="center"
        android:textSize="20sp" />

    <Button
        android:id="@+id/signup"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:text="signup"
        android:onClick="signup"
        android:textAlignment="center"
        />

</LinearLayout>

MainActivity.java


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.PatternMatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {
    EditText username,password;
    Button signup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        username=(EditText) findViewById(R.id.uid);
        password=(EditText) findViewById(R.id.pwd);
        signup = (Button) findViewById(R.id.signup);
    }
    public void signup(View v)
    {
        if(password.getText().toString().length()>=8 && validatepassword(password.getText().toString()))
        {
            Toast.makeText(this, "Signup Successfull", Toast.LENGTH_LONG).show();
            Intent i= new Intent(MainActivity.this,Login.class);
            Bundle b=new Bundle();
            b.putString("uid",username.getText().toString());
            b.putString("password",password.getText().toString());
            i.putExtras(b);
            startActivity(i);
        }
        else
        {
            Toast.makeText(this, "Password is not correct", Toast.LENGTH_LONG).show();
        }
    }

    public boolean validatepassword(String password)
    {
        Pattern ptrn;
        Matcher mat;

        String passwordptrn="^(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9])(?=.*[<>/@%$#+=&])(?=\\S+$).{8,}$";
        ptrn=Pattern.compile(passwordptrn);
        mat=ptrn.matcher(password);
        return mat.matches();

    }
}




activity_login.xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".Login"
    android:orientation="vertical">


    <TextView
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:text="Login Activity"
        android:textAlignment="center"
        android:textColor="@color/purple_500"
        android:textSize="30sp"
        android:textStyle="bold"
        />

    <EditText
        android:id="@+id/uid"
        android:layout_width="match_parent"
        android:layout_height="62dp"
        android:ems="10"
        android:hint="Enter the Used ID"
        android:textAlignment="center"
        android:textSize="20sp" />

    <EditText
        android:id="@+id/pwd"
        android:layout_width="match_parent"
        android:layout_height="68dp"
        android:ems="10"
        android:hint="Enter the Password"
        android:inputType="textPassword"
        android:textAlignment="center"
        android:textSize="20sp" />

    <Button
        android:id="@+id/login"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:text="Login"
        android:onClick="login"
        android:textAlignment="center"
        />
</LinearLayout>

Login.java
package com.gmit.signup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {
    EditText username,password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        username=(EditText) findViewById(R.id.uid);
        password=(EditText) findViewById(R.id.pwd);

    }

    public void login(View v)
    {
        Bundle b=getIntent().getExtras();
        String uname=b.getString("uid");
        String passwd=b.getString("password");
        if(username.getText().toString().equals(uname) && password.getText().toString().equals(passwd))
        {
            Toast.makeText(this, "Login Sucessfull", Toast.LENGTH_LONG).show();
            Intent i=new Intent(Login.this,Success.class);
            startActivity(i);

        }
        else
        {
            Toast.makeText(this, "Login in Unsucessfull", Toast.LENGTH_LONG).show();
        }
    }
}

activity_success.xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".Success"
    >


    <TextView
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:text="Login Sucessfull"
        android:textAlignment="center"
        android:textSize="30sp"
        android:layout_gravity="center"
        android:textColor="#264FE1"

        />
</LinearLayout>

Success.java
package com.gmit.signup;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class Success extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_success);
    }
}
