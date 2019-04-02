package swing.study;
import org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * 多选图片卡片布局
 */
public class ImageFrame extends JFrame implements ActionListener {
    private  JButton chooserBtn,preBtn,nextBtn;
    private JFileChooser jFileChooser;
    private JPanel centerPanel,bottomPanel;
    private CardLayout cardLayout;
    private JFileChooser fileChooser;

    public ImageFrame(){
        init();
        setTitle("使用卡片布局实现多图功能");
        setSize(1024, 768);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }


    public void  init(){
        bottomPanel = new JPanel();
        chooserBtn = new JButton("图片选择");
        add (chooserBtn,BorderLayout.NORTH);
        chooserBtn.addActionListener(this);
        preBtn = new JButton("上一张");
        nextBtn = new JButton("下一张");
        nextBtn.addActionListener(this);
        preBtn.addActionListener(this);
        bottomPanel.add(chooserBtn);
        bottomPanel.add(preBtn);
        bottomPanel.add(nextBtn);
        add(bottomPanel,BorderLayout.SOUTH);

        centerPanel = new JPanel();
        cardLayout = new CardLayout();
        centerPanel.setLayout(cardLayout);
        centerPanel.setBackground(new Color(151, 155, 192));
        add(centerPanel);
    }


    public static void main(String[] args) {
        try {
            BeautyEyeLNFHelper.frameBorderStyle = BeautyEyeLNFHelper.frameBorderStyle.osLookAndFeelDecorated;
            org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.launchBeautyEyeLNF();
        } catch (Exception e) {
            e.printStackTrace();
        }
        new ImageFrame();
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==chooserBtn) {
            fileChooser = new JFileChooser();
            //设置文件选择器的默认路径
            fileChooser.setCurrentDirectory(new File("D:\\picture"));
            //打开对话框
            fileChooser.setMultiSelectionEnabled(true);
            int result = fileChooser.showOpenDialog(null);
            //用户点击确认按钮，选择文件
            if (result == JFileChooser.APPROVE_OPTION) {
                //获取目录盘中的所有文件，放到文件类型的数组中
                File[] files = fileChooser.getSelectedFiles();
                //遍历文件数组
                for (File f : files) {
                    System.out.println(f.getAbsolutePath());
                    //对每个子文件，创建字节输入流字节数组，构建Icon,并设置给JPanel
                    try {
                        byte[] bytes = new byte[(int) f.length()];
                        InputStream inputStream = new FileInputStream(f);
                        inputStream.read(bytes);
                        Icon icon = new ImageIcon(bytes);
                        JLabel imgLabel = new JLabel();
                        imgLabel.setIcon(icon);
                        centerPanel.add(imgLabel);
                    } catch (IOException el) {
                        JOptionPane.showMessageDialog(null, "IO异常");
                    }
                }
            }
        }
     if (e.getSource()==preBtn){
         cardLayout.previous(centerPanel);
     }
     if (e.getSource()==nextBtn);{
         cardLayout.next(centerPanel);
        }
    }
}
