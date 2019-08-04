package ir.all.share

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.baoyz.widget.PullRefreshLayout
import ir.all.adapter.CustomAdapter
import ir.all.adapter.CustomList
import ir.all.myapplication.R


class Page_tazeha_frag : androidx.fragment.app.Fragment() {

    private lateinit var pull: PullRefreshLayout
    private lateinit var rootView: View
    private lateinit var lst: ArrayList<CustomList>
    private lateinit var adapter: CustomAdapter
    private lateinit var rc: androidx.recyclerview.widget.RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        rootView = inflater.inflate(R.layout.page_tazeha_frag, container, false)
        pull = rootView.findViewById(R.id.pull)
        pull.setRefreshStyle(PullRefreshLayout.STYLE_CIRCLES);
        rc = rootView.findViewById(R.id.rc)
        lst = ArrayList()

        lst.add(CustomList("test", R.mipmap.ic_launcher))
        lst.add(CustomList("test", R.mipmap.ic_launcher))
        adapter = CustomAdapter(lst);
        rc.layoutManager = androidx.recyclerview.widget.LinearLayoutManager(container!!.context)
        rc.adapter = adapter

        pull.setOnRefreshListener {
            pull.postDelayed(Runnable {
                run {
                    pull.setRefreshing(false)
                }
            },4000)
        }

        return rootView
    }

}
