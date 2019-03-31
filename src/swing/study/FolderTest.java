package swing.study;

import java.io.File;
/**
 * 获取d盘文件夹图片格式
 * @author 许源
 * 2019.4.1
 */
public class FolderTest {
    public static void main(String[] args) {
        //遍历路径
        String path = "D:\\java1";
        //获取file对象
        File file = new File(path);
        //遍历path下文件
        File[] fs = file.listFiles();
        for (File f : fs) {
            String srcFileName = f.getName();
            int position = srcFileName.indexOf(".");
            String suffixName = srcFileName.substring(position);
            if (suffixName.equals(".jpg") | suffixName.equals(".png")) {
                System.out.println(f);
            }
        }
    }
}
