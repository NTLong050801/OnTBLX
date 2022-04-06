package adapter;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.onblx.GroupCauHoi;
import com.example.onblx.R;

import java.util.List;

public class GrCauHoiAdapter extends BaseAdapter {
    private Context context;
    private int layout;
    private List<GroupCauHoi> groupCauHoiList;

    public GrCauHoiAdapter(Context context, int layout, List<GroupCauHoi> groupCauHoiList) {
        this.context = context;
        this.layout = layout;
        this.groupCauHoiList = groupCauHoiList;
    }

    @Override
    //trả về số dòng
    public int getCount() {
        return groupCauHoiList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    //trả về mỗi dòng
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = inflater.inflate(layout,null);
        //ánh xá
        TextView tvtitle = (TextView) view.findViewById(R.id.tvtitle);
        TextView tvnoidung = (TextView) view.findViewById(R.id.tvnoidung);
        TextView tvCauDaLam = (TextView) view.findViewById(R.id.tvCauHoidalam);
        TextView tvTongcauhoi = (TextView) view.findViewById(R.id.tvTongcauhoi);
        // gán giá trị
        GroupCauHoi groupCauHoi = groupCauHoiList.get(i);
        tvtitle.setText(groupCauHoi.getTitle());
        tvnoidung.setText(groupCauHoi.getNoidung());
        tvCauDaLam.setText(groupCauHoi.getSocaulam());
        tvTongcauhoi.setText(groupCauHoi.getSocauhoi());
        return view;
    }
}
