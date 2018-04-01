package com.zqf.kotlindemo

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Switch
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.toast
import org.jetbrains.anko.uiThread
import java.net.URL
import java.util.logging.Logger

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //点击事件
        btn.setOnClickListener {
            //设置文本
            tv.setText("新文本")
            Toast.makeText(this, "改变了文本", Toast.LENGTH_SHORT).show()
        }
        //基本数据类型  集合
        var a:Int=3
        var b:String="我是字符串"
        var c:Float=1.111f
        var d:Double=2.222
        var f= arrayOf(1,4,2,3)
        var g= arrayOf("苹果","梨","香蕉")
        println("a:${a},b:${b},c:${c},d:${d},f:${f[2]},g:${g[2]}")

        val list1=ArrayList<String>()
        val list2= arrayListOf<String>("aaaa","bbb","ccc")
        val  map= HashMap<Int,String>()
        //集合添加元素
        for (k in 0..10){
            list1.add(""+k)
        }
        //遍历list1  方式一
        for (z in 0..list1.size-1 ){
            println("list1:"+list1.get(z))
        }
        //遍历list2  方式二
        for (y in list2){
            println("list2:"+y)
        }
        //方式三
        for ((xiabiao , yuansu) in list2.withIndex()){
            println("${xiabiao}=${yuansu}")
        }

        //变量var  常量 val
        var bianliang:Int=222
        bianliang=30//可以直接修改

        val changliang:Int=333
//        changlian=2222//   Unresolved reference: changlian

        //表达式 + - * / 类型转换
        var h:Int = 6
        var i:Int = 4
        println("h/i=${h/i}")               // =1
        println("h/i=${h.toDouble()/i}")   // =1.5

        //三大结构
        //顺序结构
        println("第一行")
        println("第二行")
        println("第三行")
        //选择结构
        if(h>i){
            println("h大")
        }else{
            print("i大")
        }
        //循环结构
        for (e in g){
            println(e)
        }
        //switch
        when(h-i){
            1->{
                println("h-i等于1")
            }
            2->{
                println("h-i等于2")
            }
        }


        //内置 工具类
        val ceil:Double = Math.ceil(d)
        println(ceil)

        //这个方法是Anko里的
        /**
         * compile "org.jetbrains.anko:anko-sdk15:0.9.1" // So here it's 15 too
         * compile "org.jetbrains.anko:anko-appcompat-v7:0.9.1"
         * compile "org.jetbrains.anko:anko-design:0.9.1"
         */
        doAsync {
            var url : String="http://v.juhe.cn/toutiao/index?type=top&key=dbedecbcd1899c9785b95cc2d17131c5"
            var readText : String = URL(url).readText()
            println(readText)
            uiThread {
                toast("${readText}")
            }
        }

    }
}




