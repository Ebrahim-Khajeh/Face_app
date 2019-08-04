package ir.all.adapter

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import ir.all.myapplication.R
import kotlinx.android.synthetic.main.adapter.view.*

class CustomAdapter(var ls: ArrayList<CustomList>) : androidx.recyclerview.widget.RecyclerView.Adapter<CustomAdapter.SetClassVar>() {

    private lateinit var lst: ArrayList<CustomList>
    private lateinit var inflater: LayoutInflater
    private lateinit var rootView : View

    init {
        lst = ls
    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): CustomAdapter.SetClassVar {
        inflater = LayoutInflater.from(p0.context)
        rootView = inflater.inflate(R.layout.adapter,p0, false)

        return SetClassVar(rootView)
    }

    override fun getItemCount() = lst.size

    override fun onBindViewHolder(p0: CustomAdapter.SetClassVar, p1: Int) {
            p0.txtTitr.text = lst.get(p1).getTitr()
            p0.imageId.setBackgroundResource(lst[p1].getImageid())
    }

    class SetClassVar(itemView: View) : androidx.recyclerview.widget.RecyclerView.ViewHolder(itemView) {
        public var txtTitr: TextView
        public var imageId: ImageView
        init {
            txtTitr = itemView.findViewById(R.id.txtadapter1)
            imageId = itemView.findViewById(R.id.imgadapter)
        }
    }
}