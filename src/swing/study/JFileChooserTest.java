package swing.study;

import org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Scanner;

/**
 * 文件选择器组件
 * @author 许源
 * 2019年4月2日
 */
public class JFileChooserTest extends JFrame implements ActionListener {
    private JButton chooserbtn;
    private JLabel pathLable;
    private JFileChooser fileChooser;

    public JFileChooserTest(){
        init();
        setTitle("CardLayout");
        setSize(900, 600);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }


    private void init(){
        chooserbtn = new JButton("选择文件");
        pathLable = new JLabel("暂无选择");
        Font font = new Font("微软雅黑",Font.BOLD,26);
        chooserbtn.addActionListener(this);
        pathLable.setFont(font);
        add(pathLable);
        add(chooserbtn, BorderLayout.NORTH);

    }



    public static void main(String[] args) {
        //颜色
        try {
            BeautyEyeLNFHelper.frameBorderStyle = BeautyEyeLNFHelper.frameBorderStyle.osLookAndFeelDecorated;
            org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.launchBeautyEyeLNF();
        } catch (Exception e) {
            e.printStackTrace();
        }
        new JFileChooserTest();
    }



    @Override
    public void actionPerformed(ActionEvent e) {
        //创建JFileChooser对象
      fileChooser = new JFileChooser();
      //设置文件选择器的默认路径
        fileChooser.setCurrentDirectory(new File("D:\\"));
        //打开对话框
        int result = fileChooser.showOpenDialog(null);
        //用户点击了"确认"按钮
        if (result == JFileChooser.APPROVE_OPTION){
            //得到一个文件但不能选择多项
            File file = fileChooser.getSelectedFile();
            try{
                InputStream inputStream =new FileInputStream(file);
                Scanner scanner = new Scanner(inputStream);
                pathLable.setText(scanner.nextLine());
            }catch (FileNotFoundException e1){
                e1.printStackTrace();
            }
            //获取绝对路径
            pathLable.setText(file.getAbsolutePath());
        }
    }
}
