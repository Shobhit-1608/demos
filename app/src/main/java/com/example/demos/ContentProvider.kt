package com.example.demos

import android.net.Uri
import android.os.Bundle
import android.widget.ListView
import android.widget.SimpleCursorAdapter
import androidx.appcompat.app.AppCompatActivity
import android.Manifest
import android.content.pm.PackageManager
import android.os.Build


class ContentProvider : AppCompatActivity() {
    lateinit var cpListview: ListView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_content_provider)
        cpListview = findViewById(R.id.cpListView)
        val uriSms: Uri = Uri.parse("content://sms/inbox")
        var fromColumn = arrayOf("body","address")
        var toTextView = intArrayOf(android.R.id.text1,android.R.id.text2)
        var rowLayout = android.R.layout.simple_list_item_2  //C:\Users\Admin\AppData\Local\Android\Sdk\platforms\android-28\data\res\layout

        if(!checkReadSMSPermission()){
            //  onPermissionCallBack = this
            getReadSMSPermission();
        }

        var dataCursor =
            contentResolver.query(uriSms,null,null,null,null,null)

        var adapter:SimpleCursorAdapter =
        SimpleCursorAdapter(this,rowLayout,dataCursor,fromColumn,toTextView,1)
        cpListview.adapter =adapter
    }

    private fun getReadSMSPermission() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (!checkReadSMSPermission()) {
                requestPermissions(
                    arrayOf(Manifest.permission.READ_SMS),
                    REQUEST_READ_SMS_PERMISSION
                )
                return
            }
        }
    }

    private fun checkReadSMSPermission(): Boolean {
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (checkSelfPermission(Manifest.permission.READ_SMS) == PackageManager.PERMISSION_GRANTED) {
                true
            } else {
                false
            }
        } else {
            true
        }
    }

    var REQUEST_READ_SMS_PERMISSION = 123
    var onPermissionCallBack: RequestPermissionAction? = null

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

    }

}

interface RequestPermissionAction {
    fun permissionDenied()
    fun permissionGranted()

}
