package database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DataBase extends SQLiteOpenHelper {
    public static final String DB_OnThiBLX = "db_blx";
    public static final int DB_VERSION = 1;

    public DataBase(@Nullable Context context) {
        super(context, DB_OnThiBLX, null, DB_VERSION);
    }
    //truy vấn không trả về kết quả
    public void QueryData(String sql){
        SQLiteDatabase database = getWritableDatabase();
        database.execSQL(sql);
    }
    // truy vấn có kết quả
    public Cursor GetData(String sql){
        SQLiteDatabase database = getReadableDatabase();
        return database.rawQuery(sql,null);
    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        TaoBang(sqLiteDatabase);
        InsertDatabase(sqLiteDatabase);
    }

    private void InsertDatabase(SQLiteDatabase sqLiteDatabase) {
        String data = "INSERT INTO \"LoaiCauHoi\" (\"IDLoaiCauHoi\",\"TenLoaiCauHoi\") VALUES (1,'Lý thuyết'),\n" +
                " (2,'Biển báo'),\n" +
                " (3,'Sa Hình');\n" +
                "INSERT INTO \"DeThi\" (\"MaDe\",\"TenDe\") VALUES (1,'Đề 1'),\n" +
                " (2,'Đề 2'),\n" +
                " (3,'Đề 3'),\n" +
                " (4,'Đề 4'),\n" +
                " (5,'Đề 5');\n" +
                "INSERT INTO \"DapAn\" (\"MaDapAn\",\"MaCauHoi\",\"NoiDung\",\"DapAnDung\") VALUES (1,1,'Vạch kẻ đường là vạch chỉ sự phân chia làn đường, vị trí hoặc hướng đi, vị trí dừng lại',1),\n" +
                " (2,1,'Vạch kẻ đường là vạch chỉ sự phân biệt trí dừng, đỗ trên đường.',0),\n" +
                " (3,1,'Tất cả các ý nêu trên.',0),\n" +
                " (4,2,'Là phần của đường bộ được sử dụng cho các phương tiện giao thông qua lại.',1),\n" +
                " (5,2,'Là phần đường bộ được sử dụng cho các phương tiện giao thông qua lại, dải đất dọc hai bên đường để đảm bảo an toàn giao thông.',0),\n" +
                " (6,2,'Là phần đường bộ được sử dụng cho các phương tiện giao thông qua lại, các công trình, thiết bị phụ trợ khác và dải đất dọc hai bên đường để đảm bảo an toàn giao thông.',0),\n" +
                " (7,3,'Là một phần của đường được chia theo chiều ngang của đường, có bề rộng đủ cho xe đỗ an toàn.',0),\n" +
                " (8,3,'Là một phần đường xe chạy được chia theo chiều dọc của đường, có bề rộng đủ cho xe chạy an toàn.',1),\n" +
                " (9,3,'Cả 02 ý trên',0),\n" +
                " (10,4,'Đường phố là đường đô thị, gồm lòng đường và hè phố.',1),\n" +
                " (11,4,'Đường phố là đường bộ ngoài đô thị có lòng đường đủ rộng cho các phương tiện giao thông qua lại',0),\n" +
                " (12,4,'Cả 02 ý nêu trên.',0),\n" +
                " (13,5,'Là bộ phận của đường để phân chia mặt đường thành hai chiều xe chạy riêng biệt hoặc để phân chia phần đường của xe cơ giới và xe thô sơ.',1),\n" +
                " (14,5,'Là bộ phận của đường để ngăn cách không cho các loại xe vào những nơi không được phép.',0),\n" +
                " (15,5,'Là bộ phận của đường để xác định ranh giới của đất dành cho người đi bộ theo chiều ngang của đường.',0),\n" +
                " (16,6,'Đường ưu tiên là đường mà trên đó phương tiện tham gia giao thông đường bộ phải nhường đường cho các phương tiện đến từ hướng khác khi qua nơi đường giao nhau, có thể được cắm biển báo hiệu đường ưu tiên.',0),\n" +
                " (17,6,'Đường ưu tiên là đường mà trên đó phương tiện tham gia giao thông đường bộ được các phương tiện đến từ hướng khác nhường đường khi qua nơi đường giao nhau, được cắm biển báo hiệu đường ưu tiên.',1),\n" +
                " (18,6,'Đường ưu tiên là đường chỉ dành cho một số loại phương tiện tham gia giao thông, được cắm biển báo hiệu đường ưu tiên.',0),\n" +
                " (19,7,'Phương tiện giao thông cơ giới đường bộ, phương tiện giao thông thô sơ đường bộ.',1),\n" +
                " (20,7,'Phương tiện giao thông thô sơ đường bộ, phương tiện giao thông cơ giới đường bộ và xe máy chuyên dùng.',0),\n" +
                " (21,7,'Cả hai ý nêu trên.',0),\n" +
                " (22,8,'Gồm xe ô tô, máy kéo, xe mô tô hai bánh, xe mô tô ba bánh, xe gắn máy, xe cơ giới dành cho người khuyết tật và xe máy chuyên dùng.',0),\n" +
                " (23,8,'Gồm xe ô tô, máy kéo, rơ moóc hoặc sơ mi rơ moóc được kéo bởi xe ô tô, máy kéo, xe mô tô hai bánh, xe mô tô ba bánh, xe gắn máy (kể cả xe máy điện) và các loại xe tương tự.',1),\n" +
                " (24,9,'Bị nghiêm cấm.',1),\n" +
                " (25,9,'Không bị nghiêm cấm.',0),\n" +
                " (26,10,'Người điều khiển xe ô tô, máy kéo, xe máy chuyên dùng mà trong máu có nồng độ cồn vượt quá 50 miligam/100 mililit máu hoặc 0.25 miligam/1 lit khí thở.',0),\n" +
                " (27,10,'Người điều khiển xe ô tô, máy kéo, xe máy chuyên dùng trên đường mà trong máu hoặc hơi thở có nồng độ cồn.',1),\n" +
                " (28,10,'Người điều khiển xe ô tô, máy kéo, xe máy chuyên dùng trên đường mà trong máu có nồng độ cồn vượt quá 80 miligam/100 mililit máu hoặc 40 miligam/1 lit khí thở',0),\n" +
                " (29,11,'Nồng độ cồn vượt quá 50 miligam/100 mililit máu.',1),\n" +
                " (30,11,'Nồng độ cồn vượt quá 40 miligam/100 mililit máu.',0),\n" +
                " (31,11,'Nồng độ cồn vượt quá 30 miligam/100 mililit máu.',0),\n" +
                " (32,12,'Bị nghiêm cấm.',1),\n" +
                " (33,12,'Không bị nghiêm cấm.',0),\n" +
                " (34,12,'Bị nghiêm cấm tùy từng trường hợp.',0),\n" +
                " (35,13,'Không bị nghiêm cấm.',0),\n" +
                " (36,13,'Nghiêm cấm tùy từng trường hợp cụ thể.',0),\n" +
                " (37,13,'Bị nghiêm cấm',1),\n" +
                " (38,14,'Nghiêm cấm sản xuất, được phép sử dụng.',0),\n" +
                " (39,14,'Nghiêm cấm mua bán,cho phép sử dụng.',0),\n" +
                " (40,14,'Nghiêm cấm sản xuất, mua bán, sử dụng trái phép.',1),\n" +
                " (41,15,'Được phép.',0),\n" +
                " (42,15,'Tùy trường hợp.',0),\n" +
                " (43,15,'Không được phép.',1);\n" +
                "INSERT INTO \"CauHoi\" (\"MaCauHoi\",\"NoiDung\",\"MaLoaiCauHoi\",\"HinhBienBao\") VALUES (1,'“Vạch kẻ đường” được hiểu như thế nào là đúng?',1,NULL),\n" +
                " (2,'Khái niệm “phần đường xe chạy” được hiểu như thế nào là đúng?',1,NULL),\n" +
                " (3,'Khái niệm “làn đường” được hiểu như thế nào là đúng?',1,NULL),\n" +
                " (4,'Khái niệm “đường phố” được hiểu như thế nào là đúng?',1,NULL),\n" +
                " (5,'Khái niệm “dải phân cách” được hiểu như thế nào là đúng?',1,NULL),\n" +
                " (6,'Khái niệm “đường ưu tiên” được hiểu như thế nào là đúng?',1,NULL),\n" +
                " (7,'“Phương tiện giao thông đường bộ” gồm những loại nào?',1,NULL),\n" +
                " (8,'Khái niệm “phương tiện giao thông cơ giới đường bộ” được hiểu như thế nào là đúng?',1,NULL),\n" +
                " (9,'Người điều khiển phương tiện giao thông đường bộ mà trong cơ thể có chất ma túy có bị nghiêm cấm hay không?',1,NULL),\n" +
                " (10,'Người điều khiển xe ô tô, xe máy kéo, xe máy chuyên dùng trên đường mà trong máu hoặc hơi thở có nồng độ cồn vượt quá bao nhiêu thì bị cấm?',1,NULL),\n" +
                " (11,'Người điều khiển xe mô tô, xe gắn máy trên đường mà trong máu có nồng độ cồn vượt quá bao nhiêu thì bị cấm?',1,NULL),\n" +
                " (12,'Hành vi điều khiển xe cơ giới chạy quá tốc độ quy định, giành đường, vượt ẩu có bị nghiêm cấm hay không?',1,NULL),\n" +
                " (13,'Hành vi bỏ trốn sau khi gây tai nạn để trốn tránh trách nhiệm hoặc khi có điều kiện mà cố ý không cứu giúp người bị tai nạn giao thông có bị nghiêm cấm hay không?',1,NULL),\n" +
                " (14,'Việc sản xuất, mua bán, sử dụng biển xe cơ giới, xe máy chuyên dùng được quy định như thế nào trong Luật giao thông đường bộ ?',1,NULL),\n" +
                " (15,'Người điều khiển xe mô tô hai bánh, ba bánh, xe gắn máy có được phép sử dụng xe để kéo, đẩy các xe khác, vật khác khi tham gia giao thông không?',1,NULL);";
    sqLiteDatabase.execSQL(data);
    }

    private void TaoBang(SQLiteDatabase sqLiteDatabase) {
        String TaoBang = "CREATE TABLE IF NOT EXISTS \"LoaiCauHoi\" (\n" +
                "\t\"IDLoaiCauHoi\"\tInteger,\n" +
                "\t\"TenLoaiCauHoi\"\tvarchar,\n" +
                "\tPRIMARY KEY(\"IDLoaiCauHoi\" AUTOINCREMENT)\n" +
                ");\n" +
                "CREATE TABLE IF NOT EXISTS \"LoaiDe\" (\n" +
                "\t\"MaLoaiDe\"\tINTEGER,\n" +
                "\t\"TenLoaiDe\"\tTEXT NOT NULL,\n" +
                "\tPRIMARY KEY(\"MaLoaiDe\" AUTOINCREMENT)\n" +
                ");\n" +
                "CREATE TABLE IF NOT EXISTS \"DeThi\" (\n" +
                "\t\"MaDe\"\tINTEGER,\n" +
                "\t\"TenDe\"\tTEXT NOT NULL,\n" +
                "\tPRIMARY KEY(\"MaDe\" AUTOINCREMENT)\n" +
                ");\n" +
                "CREATE TABLE IF NOT EXISTS \"BienBao\" (\n" +
                "\t\"MaBienBao\"\tINTEGER,\n" +
                "\t\"YNghia\"\tTEXT NOT NULL,\n" +
                "\t\"HinhAnh\"\tBLOB,\n" +
                "\tPRIMARY KEY(\"MaBienBao\" AUTOINCREMENT)\n" +
                ");\n" +
                "CREATE TABLE IF NOT EXISTS \"DapAn\" (\n" +
                "\t\"MaDapAn\"\tINTEGER,\n" +
                "\t\"MaCauHoi\"\tINTEGER NOT NULL,\n" +
                "\t\"NoiDung\"\tTEXT NOT NULL,\n" +
                "\t\"DapAnDung\"\tINTEGER NOT NULL,\n" +
                "\tPRIMARY KEY(\"MaDapAn\" AUTOINCREMENT)\n" +
                ");\n" +
                "CREATE TABLE IF NOT EXISTS \"CauHoi\" (\n" +
                "\t\"MaCauHoi\"\tINTEGER,\n" +
                "\t\"NoiDung\"\tTEXT NOT NULL,\n" +
                "\t\"MaLoaiCauHoi\"\tINTEGER NOT NULL,\n" +
                "\t\"HinhBienBao\"\tBLOB,\n" +
                "\tPRIMARY KEY(\"MaCauHoi\" AUTOINCREMENT),\n" +
                "\tFOREIGN KEY(\"MaLoaiCauHoi\") REFERENCES \"LoaiCauHoi\"(\"IDLoaiCauHoi\")\n" +
                ");";
        sqLiteDatabase.execSQL(TaoBang);
    }


    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
