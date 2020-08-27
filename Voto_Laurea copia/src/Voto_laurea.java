import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.TextArea;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

public class Voto_laurea extends JFrame implements ActionListener{
	private static final long serialVersionUID = 1L;
	Timer fps;
	JPanel p2, p1, p, p3;
	JScrollPane scrpane;
	double tot = 0, cred = 0, numcred = 0, mediaart = 0, mediapond = 0, vot = 0, somcred = 0, tot1 = 0;
	
	public Voto_laurea() {
		super();
		
		p = new JPanel();
		p1 = new JPanel();
		p2 = new JPanel();
		p3 = new JPanel();
		ArrayList<String> av = new ArrayList();
		ArrayList<String> ac = new ArrayList();
		fps = new Timer(16,this);
		fps.start();
		
		String[] choices = { "18","19", "20","21","22","23","24","25","26","27","28","29","30" };
		final JComboBox<String> cb = new JComboBox<String>(choices);
		String[] choices1 = { "6","9","12" };
		final JComboBox<String> cb1 = new JComboBox<String>(choices1);
		JLabel voto = new JLabel();
		voto.setText("Voto:");
		JLabel crediti = new JLabel();
		crediti.setText("Crediti:");
		JButton b = new JButton();
		b.setText("INSERISCI");
		JButton b1 = new JButton();
		b1.setText("MEDIA");
		
		BorderLayout gr = new BorderLayout();
		p.setLayout(gr);
		
		FlowLayout str = new FlowLayout();
		p1.setLayout(str);
		
		FlowLayout str1 = new FlowLayout();
		p3.setLayout(str1);
		
		scrpane = new JScrollPane(p2);
		p2.setLayout(new GridLayout(200,1));
		
		p1.add(voto);
		p1.add(cb);
		p1.add(crediti);
		p1.add(cb1);
		p1.add(b);
		p3.add(b1);
		p.add(p1, BorderLayout.NORTH);
		p.add(scrpane, BorderLayout.CENTER);
		p.add(p3, BorderLayout.SOUTH);
		scrpane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS); 
		scrpane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		
		b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			  {
			    av.add(cb.getSelectedItem().toString());
			    ac.add(cb1.getSelectedItem().toString());
			    JLabel l1 = new JLabel("VOTO: "+av.get(av.size()-1));
			    JLabel l2 = new JLabel("CREDITO: "+ac.get(ac.size()-1));
			    l1.setText(l1.getText()+"\t\t\t\t\t\t"+l2.getText());
			    p2.add(l1);
			    tot += Integer.parseInt(av.get(av.size()-1));
			    numcred+=1;
			  }
		});
		
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mediaart = tot / numcred;
				for(int i = 1; i < av.size(); i++) {
					cred = Integer.parseInt(ac.get(ac.size()-i));
					somcred += Integer.parseInt(ac.get(ac.size()-i));
					vot = Integer.parseInt(av.get(av.size()-i));
					tot1 += (cred*vot);
				}
				mediapond = tot1 / somcred;
				System.out.println(mediaart);
				System.out.println(mediapond);
			}	
		});
		
		setContentPane(p);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(400,300);
		setTitle("Voto Laurea");
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setLocation((screenSize.width - 400)/2, (screenSize.height - 300)/2);
		setVisible(true);
		setResizable(false);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == fps) {
			repaint();
		}
		
	}
}
