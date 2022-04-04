package com.example.onblx;

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
        String data = "INSERT INTO \"CauHoi\" (\"IDCauHoi\",\"TenCauHoi\",\"DapAn\",\"DapAnDung\",\"TheLoai\",\"AnhMinhHoa\") VALUES (1,'Đây là iển báo gì','A','A','1',X'ffd8ffe000104a46494600010100000100010000ffdb00840009060714111010100d0f100e0d0d0f0e0e100e0d16150e0f10101511161615111515191d2822181a261b1515223d2325292b2e3a3118203f38332e37282d2e2b010a0a0a0e0d0e1b10101b2d2320212f2b2d2b2b37372d2d2d2d2d2b2d2d2b2d2d2f2d2e2d2d2b2b2e2f2d2f2d2b2d2d2b2b2d2b2d2d2d2b2d2d2d2d2d2e2d2d2dffc000110800cd00f603011100021101031101ffc4001c0001000203010101000000000000000000000607010405030802ffc400461000010301020908070407090000000000000102030405110607122131515493d113151641618191a1223242526271b12382b3c21434647292a2b2333543537374c1e1f0ffc4001b01010002030101000000000000000000000004050203060107ffc400391101000201020108090303040301000000000102030411120514213141515291133253617181a1b1d122c1e13342f0233472f115438206ffda000c03010002110311003f00bc000000000019000000003000000000000003200000000000000000000000000000000000000c2a81cfb56dc82992fa999915fa1aab7bddf26a67530b64ad7d6948c1a5cd9e76c7599fb79a1b69e34636de94b4ef97e3997926f7352f55f222db591fdb0b9c3c8179e9cb788f7474ff0008dd6e30eb5f7e43e38117fcb6239c9defbfe869b6ab24f5742cb17226969eb44dbe33f872a4c29ad77ad5b3afc9c8cfe94435ce6c93da951c9fa58eac71f7fbbcba4155b5d46f1dc4f3d2dfbe59f32d37b3af93de2c2bad6fab5b37de56bd3f9914f633e4ef613c9da4b75e38fac7da5d6a2c635633fb458a74f8db90e5ef6dc9e46caeab2475f4a1e4e43d2dbd5debf3dfeff949acbc6742eb92aa19205f7d8bcb47f4472781be9acacfad1b2b33f20e5af4e2b45be93f8faa6366da90d4372a9e68e66f5ab16f54f9a694ef24d6f5b754a9f360c98678725661b88a66d2c80000000000000000000000000000000068dab6a454d1acb5323638d3ad73ab97dd6a26755ec431b5e2b1bcb760c1933df831c6f3fe792b2c22c62cd2ab99448b4f168e5573cce4ecea679afc881935569e8af43a6d1f2263c7b5b37ea9eeecfe50992457395cf739ef5d2e7aab9cbf355cea4499dfa6579588ac6d1d1f67e43d00000000001eb4d50f8dc8f85ef8a44bae7c6aac7277a7d0f62662778637a56f5e1bc6f1dd29e60e6325cdba3b41bca3347e911a7a69daf627addde0a4cc5ab9eaba8359c8559fd582769ee9eaf94fe7cd655156326636485ed9237a5ed7b16f4526c5a26378735931df1da6b78da61b064c000000000000000000000000000011ec2cc2a8a859e97da543d3ece145cebf1397d969a73668c71ef4fd0727e4d5dba3a2b1d73f8f7a9bb5ed696aa4596a5eaf7e8444ccc627bad6f521597bdaf3bd9d9e9f4d8b4f4e0c71b47d67e6d1306f000000000000000001d5c1fb7e6a2932e9dde8b9532e17dfc9c89da9d4bda9e66cc796d8e77844d5e8f16aabb648f84f6c7f9dcb9b06f0862ad8b94856e736e492275d971bb52eb4ed2cf1e58c91bc38cd668f2696fc37f94f64bae8a6d44640000000000000000000000011dc31c266d0c37e67d44b9490c5ad7adeed4d434e6cd18e3deb0e4fd05b57936eaac75cfed1ef52b5b56f9a47cb33d5f2c8b94e72f5aeaec4ec2aa6d369de5db63c75c748a523688781e330000000000000000000006e59169c94b2b66a7764bdb997dd7b6fcec7275a2dc654bcd277869d469f1e7c738ef1d1fe74af0c1ab763ad81268b3393d192355bdd1bfadabf545d45b63c917aef0e1b59a4be972705be53df0eb9b114000000000000000000001a56b5a2ca78649e65b991355cbad57a9a9daab72185ed15af14b6e0c37cd9231d3ae543db56ac9573be7997d27ae662676c6c4d0c6f62712a6f79bdb8a5dee9b4d4d3e38c74ecedef9ef6898378000000000000000000000000ec60b5baea2a86cadbd6275cc9a34f6e3bfea97aaa7fd9b71649c76dd0f5da3aeab14d27afb27dff00caf5a4a86c8c6491391f1c8d6bd8e4d0ad54bd14b689898de1c25e96a5a6b68da63a25ec7ac4000000000000000006140a9b1a36ef2b3a5246bf654ca8e92ef6a654d1f7517c557515daac9bdb863aa1d6721e93d1e3f4d6ebb757c3f941888bd00000000000000000000000000005938a9b77d6a195da11d2c17fbbedc7dda7bd7513b4993fb27e4e6b97749d5a8afc2dfb4fecb2509ce6d90000000000000000073adfb492969a69ddfe13155135b97335bdeaa886bc97e0acd9bf4b8273e6ae38ed9ffb7cff00248ae739ef5ca7bdcaf73974b9cab7aaf894f33bf4be8311158888ea8e887e43d00000000000000000000000000006cd9d5cea79a39e3f5e17a3d135dda5bde97a779956d359e28ec6bcd86b9b1ce3b754f47f9f77d094750d9236491adec91ad7b57b152f42e62778de1f3cbd26969a5bae3a1ec7ac40000000000000002bcc6eda1931414c8b9e67accf4f863baebfef2a7810b596e88aba0e40c3be4b659ec8dbe73fc2af203a90000000000000000000000000000000170e2b2d0e52879372deea591d17dc5f49be17aa77167a4bef4dbb9c772de1e0d4f14755a37f9f54a6449538000000000000030a05358cfaacbb41cdbf3411451dda956f7aff0052157aa9df27c1d972263e1d2efdf333fb224475b80632935a1e6e6c6526b41bbdd8ca4d68373632935a0dcd8ca4d68373632935a0dcd8ca4d68373632935a0dcd8ca4d68373632935a0dcd8ca4d68373632935a0dcd8ca4d68373632935a0dcd8ca4d687bb9b321e004f314557754cf0aae696149513e28de88be4ff22668e7f54c28797f16f86b93ba76f38fe16b960e500000000000000050283c2e972ed0ac77ed1233f83d0fca53e69df25be2efb93ebc3a5c71ee89f3e9720d696ea60b468eaea46b911cd754468ad7222b552fd0a8ba4d98bd7afc5175d331a6c931dd2bc12c6a7d9a9f76ce05af057b9c3f39cde3b79cb3ccf4fb2d3eed9c07057ba0e739bc76f39399e9f65a7ddb380e0af741ce7378ede72733d3ecb4fbb6701c15ee839ce6f1dbce4e67a7d969f76ce0382bdd0739cde3b79c9ccf4fb2d3eed9c07057ba0e739bc76f39399e9f65a7ddb380e0af741ce7378ede72733d3ecb4fbb6701c15ee839ce6f1dbce4e67a7d969f76ce0382bdd0739cde3b79c9ccf4fb2d3eed9c07057ba0e739bc76f39399e9f65a7ddb380e0af741ce7378ede72733d3ecb4fbb6701c15ee839ce6f1dbce4e67a7d969f76ce0382bdd0739cde3b79c9ccf4fb2d3eed9c07057ba0e739bc76f39399e9f65a7ddb380e0af741ce7378e7ce540d7a5d34c8897224d322226644447adc853dbae7e6eff000ff4ebf08fb3c0f19a518b59726d28be364d1f8b6ffca848d2cffa90abe59aefa4b7ba62575968e280000000000000003e7bc20fd72b2fd3fa655fe3bca6c9ebdbe32fa1697fdbe3ff008d7ed0d0306f75b04bf5fa3ff7317d4d987fa95f8a26bffdae4ff8cafd2de1c087a000000000000000000000007ce968ff006d37fad37e238a4b7ad3f197d1b0ff004ebf08fb435cf19a438bff00ef2a5fde93f0dc6ed3ff005215fcadfed2ff002fbc2f22d9c30000000000000030a050b8610e45a158dfda1eff00e3b9ff0098a7cd1b64b7c5def27db8b4b8e7dd1f4e871cd698ea60bcad656d23e472318c9e3739ee546b5a88ba55574219e2988bc4cf7a2eb6b36d35e2b1bccc4aeb4c23a4db6977ace25afa5a77c389e65a9f676f293a4749b6d2ef59c47a5c7e287bccb53ecede52748e936da5deb388f4b8fc50732d4fb3b7949d23a4db6977ace23d2e3f141ccb53ecede52748e936da5deb388f4b8fc50732d4fb3b7949d23a4db6977ace23d2e3f141ccb53ecede52748e936da5deb388f4b8fc50732d4fb3b7949d23a4db6977ace23d2e3f141ccb53ecede52748e936da5deb388f4b8fc50732d4fb3b7949d23a4db6977ace23d2e3f141ccb53ecede52748e936da5deb388f4b8fc50732d4fb3b7949d23a4db6977ace23d2e3f141ccb53ecede52748e936da5deb388f4b8fc50732d4fb3b7949d23a4db6977ace23d2e3f141ccb53ecede52748e936da5deb388f4b4ef83996a7d9dbca543d73916595516f459a55454ce8a8af554542a2deb4bbcc51318eb13dd1f6781e334a31691655a517c11ccff0006ddf9891a68ff005157cb56db496f7cc42eb2d1c50000000000000030a05378d0a5c8b415d7669e18e4f9aa5ed5fe942b3555db26fdeec790f2716976ee998fdd11232e00170000000000000000000000000000013dc5151df515132a668e148917b5ef472f9313c499a3afea99507ffa0cbb62a63ef9dfca3f95ac583950000000000000000afb1bb67e543054a26781eb1397e192ebbf99a9e243d6577ac59d072066db25b14f6c6ff38fe15695eea400000000000000000000000000000005c58aeb3d62a1491c973aaa474bf713d167936fef2cf4b5da9bf7b8ee5bcde9353c31d558dbe7d72989254e0000000000000001a16ed9c9534f340fd12b15a8ba9da5aeee544530c94e3acd5bf4d9e7065ae48ec9ff00b7cfd344e639cc9115af8dce639aba51cd5b953c4a798dba25f40ada2d116af54f53f078c80000000000000000000000000001b565d03aa268a08fd799e8c45f7534abbb91154cab59b5a2b0d59f3570e39c96ea87d074903636323625cc8dad635352225c85cd6368d9f3dbde6f69b4f5cbd8f5880000000000000006140aa31a761727336b234fb3a85464b77b32a26677de44f14ed2bb578f69e38ed757c87ace3c7382dd75e98f87f0821117c0000000000000000000000000000b3315360aa23ab656dcaf458e0bf4e47b7277ae6ee5d64fd263fef9f9399e5dd66f31a7acf574cfc7b216322135ce320000000000000000001a96a59eca889f0cc9951cad56aeb4d4e45ea545ce637ac5a3696dc39ad872464a75c287b76c87d24ef825d2dced7f548c5d0f4ffda6f2a3252696e19779a5d4d3538a3253b7e93dce798240000000000000000000000000ed609d80eaea848d2f485973e77a7b2ccf993e25b9513bf51b70e29c96dbcd0b5facae9717176cfab1effc42f3a681b1b191c6d46471b5ac635b991ad44b9113b8b688da36870b7bdaf69b5ba665ec7ac4000000000000000000001c1c2ec1b6574392b73278ef7432fbae5ea76b6af59a73628c91ef4ed06bada4c9c51d313d71fe76a92afa27c123e19d8b1cb1adce6af93917ad1759556acd676976f8b2d32d22f49de25ae78d8000000000000000000000deb16c992ae66c34edbdcb9dce5f56365f9dee5ea433a52d79da1a353a9c7a7c7392fd5f79ee5e183b6247470361892fbbd27c8beb48f5d2e5e1a8b5c78e295da1c36af557d4e49c97f947743aa6c460000000000000000000000001c0c2bc178aba3b9ff673b117929da97b9bf0aa7b4d5d5e171ab2e1ae48e94ed0ebf2692dbd7a6b3d71dff895376d58d35249c9d4b15abecbd33c7226b6bbafe5a4abbe3b5276b3b3d36ab16a29c58e7e31db0e79824000000000000000000ec60e60e4d5afc985b931b57d39de8bc9b3b3e27762791b7162b649e843d66bb1696bbdfa67b23b67f0b9707ac18a8a2e4e06e75cef91d9df23b5b97fe341678f1d71c6d0e3357abc9a9bf1de7e11d90eb1b1140000000000000000000000000001a96959d15446b1d446d96377b2f4bee5ea54d4bda8636ac5a3696cc39af86dc78e7695678458b8923bdf40ab3c7a7917aa24ad4d4d72e67f92fcc81934968e9af4ba6d272e52ff00a73fe99efecfe1069e1731cac91ae8e46e963d15ae4ee5224c4c4ed2bda5ab7af156778ef7e03200000000001ed4748f99fc9c11ba5917d88d3297bf57cd4f6b59b4ed10c3264a62af15e6223deb0306f16caaad92d1764a69fd1a35bd57b1ef4fa37c4998b49db7f273face5d8e9ae9e3ff00a9fda3f2b1a92919131b1c2c6c71b12e6b1888d6a27c909d11111b439bbded92dc579de65ee7ac4000000000000000000000000000000062e034ad2b261a86e4d4c2c953ab2d2f727c974a77185a95b7ad0dd8751970cef8ed30875a58b085d7ad34d2c2aba1925d2b13e5a1de6a46b68ebfdb3b2e70f2fe5af464ac4fd27f1f446eb316f58c5fb3e4266eb63d58ef07227d4d13a4c91d4b2c7cb9a5b47eade3e5bfdbf0e5cd81f5add34722f6b725c9e4a6b9c1923b12abca7a49ff00d91f578f462b3639ff0084f3d0e4ee67ff0090d2fb486c4181b5ced149237b5ead6a79a99460c93d8d76e54d257fbe3ebf87568b16b56f5fb5741037f79657f8225de66c8d25e7af6844c9cbba6afab136fa7eff00b24d6662ce9d972d4492d42a7b37f251f82675f137d74948f5ba5599b97b3dba31c457eb3f8fa2614167c7037220899133dd8d11be3ac935ad6b1b4429f265be59e2bccccb6ae326b000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000600c80000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001ffd9');;\n";
    sqLiteDatabase.execSQL(data);
    }

    private void TaoBang(SQLiteDatabase sqLiteDatabase) {
        String CauHoi = "CREATE TABLE IF NOT EXISTS \"CauHoi\" (\n" +
                "\t\"IDCauHoi\"\tINTEGER NOT NULL,\n" +
                "\t\"TenCauHoi\"\tTEXT NOT NULL,\n" +
                "\t\"DapAn\"\tTEXT NOT NULL,\n" +
                "\t\"DapAnDung\"\tTEXT NOT NULL,\n" +
                "\t\"TheLoai\"\tTEXT NOT NULL,\n" +
                "\t\"AnhMinhHoa\"\tBLOB,\n" +
                "\tPRIMARY KEY(\"IDCauHoi\")\n" +
                ");";
        sqLiteDatabase.execSQL(CauHoi);
    }


    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
