package swing.study;
import org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper;

import javax.swing.*;
import java.awt.*;
/**
 * BoxLayoutTest练习
 * @author  许源 2019年3月29日
 */

public class BoxLayoutTest extends JFrame {
    public BoxLayoutTest(){
        init();
        setTitle("BoxLayout");
        setSize(440,790);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
    public void init(){
        //重新设置窗体布局为具水平和垂直间距的BorderLayout
        setLayout(new BorderLayout(20,20));
        //顶部面板
        JPanel topPanel = new JPanel();
        //对topPanel进行水平方向排列的BoxLayout
        BoxLayout boxLayout = new BoxLayout(topPanel,BoxLayout.X_AXIS);
        topPanel.setLayout(boxLayout);
        //toPanel设置背景色和合适大小
        topPanel.setBackground(new Color(109, 94, 255));
        topPanel.setPreferredSize(new Dimension(434,120));
        //左侧按钮
        JButton leftButton = new JButton("扫一扫");
        leftButton.setPreferredSize(new Dimension(90, 40));
        topPanel.add(leftButton);
        //加入一个glue, 会挤占两个按钮之间的空间
        topPanel.add(Box.createHorizontalGlue());
        //右侧按钮
        JButton rightButton = new JButton("会员码");
        rightButton.setPreferredSize(new Dimension(90,50));
        topPanel.add(rightButton);
        //topPanel家兔窗体顶部
        add(topPanel,BorderLayout.NORTH);
        //中间的middlePanel面板，垂直方向的BoxLayout
        JPanel middlePanel = new JPanel();
        middlePanel.setLayout(new BoxLayout(middlePanel,BoxLayout.Y_AXIS));
        //创建三个面板，加入middlePanel
        for (int i= 0;i<3;i++){
            JPanel jPanel = new JPanel();
            jPanel.setPreferredSize(new Dimension(410,120));
            jPanel.setBackground(new Color(90, 205, 152));
            //分别将每次创建的面板加入middlePan
            middlePanel.add(jPanel);
            //每个加入的面板下方，加入一个垂直方向的Strut，空出一点距离
            middlePanel.add(Box.createVerticalStrut(20));
        }
        //最后将加入窗体的中间区域
        add(middlePanel, BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        try {
            BeautyEyeLNFHelper.frameBorderStyle = BeautyEyeLNFHelper.FrameBorderStyle.osLookAndFeelDecorated;
            org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.launchBeautyEyeLNF();
        }catch (Exception e){
            e.printStackTrace();
        }
        new BoxLayoutTest();
    }
}
