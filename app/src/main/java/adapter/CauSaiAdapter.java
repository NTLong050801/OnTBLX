package adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.onblx.CauHoi;
import com.example.onblx.GroupCauHoi;
import com.example.onblx.R;

import java.util.List;

public class CauSaiAdapter extends BaseAdapter {
    private Context context;
    private int layout;
    private List<CauHoi> groupCauHoiList;

    public CauSaiAdapter(Context context, int layout, List<CauHoi> groupCauHoiList) {
        this.context = context;
        this.layout = layout;
        this.groupCauHoiList = groupCauHoiList;
    }

    @Override
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
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = inflater.inflate(layout,null);
        //ánh xá
        TextView tvtitleCausai = (TextView) view.findViewById(R.id.tvtitleCausai);

        // gán giá trị
        CauHoi cauHoi = groupCauHoiList.get(i);
        tvtitleCausai.setText(cauHoi.getNoiDung());

        return view;
    }
}
