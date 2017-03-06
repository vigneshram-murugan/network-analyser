
import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintStream;
import javax.swing.JOptionPane;
import jpcap.JpcapCaptor;
import jpcap.NetworkInterface;
import jpcap.NetworkInterfaceAddress;
import org.jfree.ui.RefineryUtilities;

public class networkpacketanalyser extends javax.swing.JFrame {
    
    NetworkInterface[] NETWORK_INTERFACES; 
    JpcapCaptor CAP;
    GUIThread threadObj; 
    int INDEX = 0; 
    int COUNTER = 0;
    boolean CaptureState = false; 
    static int igraph=0;
    static int[] arr=new int[10000];
    static int arparr=0;
    
    public networkpacketanalyser() {
        initComponents();
    }
    
    @SuppressWarnings("unchecked")
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        list = new javax.swing.JButton();
        jSeparator4 = new javax.swing.JSeparator();
        chooseinterface = new javax.swing.JTextField();
        exit = new javax.swing.JButton();
        load = new javax.swing.JButton();
        interfacedetails = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        porttext = new javax.swing.JTextField();
        filter = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        textarea = new javax.swing.JTextArea();
        capture = new javax.swing.JButton();
        pause = new javax.swing.JButton();
        save = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel5 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        generetegraph = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Network Packet Analyser");

        list.setText("list");
        list.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listinterface(evt);
            }
        });

        chooseinterface.setFont(new java.awt.Font("Sylfaen", 2, 16)); // NOI18N
        chooseinterface.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chooseinterfaceActionPerformed(evt);
            }
        });

        exit.setText("exit");
        exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitActionPerformed(evt);
            }
        });

        load.setText("load");
        load.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loadActionPerformed(evt);
            }
        });

        interfacedetails.setText("interface details");
        interfacedetails.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                interfacedetailsActionPerformed(evt);
            }
        });

        jLabel3.setText("Ports :");

        jLabel4.setText("port filter :");

        porttext.setFont(new java.awt.Font("Sylfaen", 2, 16)); // NOI18N

        filter.setText("filter");
        filter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filterActionPerformed(evt);
            }
        });

        textarea.setEditable(false);
        textarea.setColumns(10000);
        textarea.setFont(new java.awt.Font("Monospaced", 1, 12)); // NOI18N
        textarea.setRows(10000);
        textarea.setTabSize(10000);
        textarea.setToolTipText("");
        textarea.setWrapStyleWord(true);
        textarea.setAutoscrolls(false);
        jScrollPane1.setViewportView(textarea);

        capture.setText("capture");
        capture.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                captureActionPerformed(evt);
            }
        });

        pause.setText("pause");
        pause.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pauseActionPerformed(evt);
            }
        });

        save.setText("save");
        save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveActionPerformed(evt);
            }
        });

        jLabel1.setText("Packet :");

        jLabel5.setText("Graph :");

        jLabel2.setText("Interface :");

        generetegraph.setText("Generate Graph");
        generetegraph.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                generetegraphActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 939, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel1)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addGap(246, 246, 246))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(list)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(interfacedetails)
                                                .addGap(36, 36, 36)
                                                .addComponent(exit)))
                                        .addGap(45, 45, 45))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(24, 24, 24)))
                                .addComponent(jLabel3)
                                .addComponent(jLabel4)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel5)
                                    .addGap(18, 18, 18)
                                    .addComponent(generetegraph)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(24, 24, 24))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(chooseinterface, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(load))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(capture)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(pause)
                                        .addGap(18, 18, 18)
                                        .addComponent(save, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jSeparator3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(filter, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(porttext, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(112, 112, 112))))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 466, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(load)
                            .addComponent(chooseinterface, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(list))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(save)
                            .addComponent(pause)
                            .addComponent(capture))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)
                        .addGap(2, 2, 2)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(porttext, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(filter)
                        .addGap(1, 1, 1)
                        .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel5))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addComponent(generetegraph)))
                        .addGap(18, 18, 18)
                        .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(exit)
                            .addComponent(interfacedetails))))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void chooseinterfaceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chooseinterfaceActionPerformed

    }//GEN-LAST:event_chooseinterfaceActionPerformed

    private void listinterface(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listinterface
      
        NETWORK_INTERFACES = JpcapCaptor.getDeviceList();
       textarea.setText(""); 
       for(int i = 0; i < NETWORK_INTERFACES.length; i++){
           textarea.append( "\n\n---------------------------------- Interface " + i + " Info---------------------------------------------- "); 
           textarea.append("\nInterface Number: " + i);
           textarea.append("\nDescription: " + NETWORK_INTERFACES[i].name + "(" + NETWORK_INTERFACES[i].description+")");
           textarea.append("\nDatalink Name: " + NETWORK_INTERFACES[i].datalink_name + "(" + NETWORK_INTERFACES[i].datalink_description+")");
           textarea.append("\nMAC address: "); 
           byte[] R = NETWORK_INTERFACES[i].mac_address;
           for(int A = 0; A <= NETWORK_INTERFACES.length; A++) {
               textarea.append(Integer.toHexString(R[A] & 0xff) + ":"); } 
           NetworkInterfaceAddress [] INT = NETWORK_INTERFACES[i].addresses; 
           textarea.append("\nIP Address: " + INT[0].address); 
           textarea.append("\nSubnet Mask: " + INT[0].subnet); 
           textarea.append("\nBroadcast Address: " + INT[0].broadcast); 
           COUNTER++; 
       }
    }//GEN-LAST:event_listinterface
    
    private void captureActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_captureActionPerformed

        for(int j=0;j<10000;j++){
            arr[j]=0;
        }
        arparr=0;
        CaptureState=true;
        threadObj = new GUIThread(){
        @Override
            public Object construct(){
               textarea.setText("\nNow CAPTURING on Interface " + INDEX + "..." + "\n --------------------------"+"--------------------\n\n") ;
                try{ 
                    CAP = JpcapCaptor.openDevice( NETWORK_INTERFACES[INDEX], 65535, false, 20); 
                    while(CaptureState){
                        CAP.processPacket(1, new PacketContents());
                        igraph++;
                    }
                    CAP.close();
                }
                catch(Exception X){
                    System.out.print(X);
                }
                return 0;
            }
        @Override
        public void finished(){
            this.interrupt();
        }
        };
        threadObj.start();
        
    }//GEN-LAST:event_captureActionPerformed

    private void pauseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pauseActionPerformed
        CaptureState = false; 
        threadObj. finished();        
    }//GEN-LAST:event_pauseActionPerformed

    private void saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveActionPerformed
       
        String CaptureData = textarea.getText(); 
        try 
        {
            File DATA = new File("capturedata.txt"); 
            FileOutputStream DATASTREAM = new FileOutputStream(DATA); 
            PrintStream OUT = new PrintStream(DATASTREAM); 
            OUT.print(CaptureData); 
            OUT.close();
            DATASTREAM.close();
            JOptionPane.showMessageDialog(null,"Data SAVED successfully!"); 
        }
        catch(Exception X) {
            JOptionPane.showMessageDialog(null,"File Access Error! Could not SAVE data.");
        }       
    }//GEN-LAST:event_saveActionPerformed

    private void loadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loadActionPerformed
         
         int TEMP = Integer.parseInt(chooseinterface.getText()); 
         if(TEMP >-1 && TEMP < COUNTER) {
         INDEX = TEMP; 
         }
         else 
         {
             JOptionPane.showMessageDialog( null,"Outside of RANGE. # interfaces = 0 -" + (COUNTER-1) + ".");
         }
         chooseinterface.setText("");        
    }//GEN-LAST:event_loadActionPerformed

    private void filterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filterActionPerformed

        try 
        {
            String PORT = porttext.getText();
            CAP.setFilter("port " + PORT, true); 
        }
        catch (Exception Y){
            System.out.print(Y);
        }        
    }//GEN-LAST:event_filterActionPerformed

    private void generetegraphActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_generetegraphActionPerformed

        GraphGeneretion obj=new GraphGeneretion("Packet Analyser");
        obj.pack();
        RefineryUtilities.centerFrameOnScreen(obj);
        obj.setVisible(true);
        
    }//GEN-LAST:event_generetegraphActionPerformed

    private void exitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitActionPerformed

        setVisible(false); 
        dispose();  
        
    }//GEN-LAST:event_exitActionPerformed

    private void interfacedetailsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_interfacedetailsActionPerformed

        String MESSAGE = 
                "\nCAPTURE = Start capturing packets." + 
                "\npause = Stop capturing packets." + 
                "\nLIST = List network interfaces on host." + 
                "\nLOAD = Select interface to capture packets with." +
                "\nFILTER = Filter on a selected port." +
                "\nGenerete Graph = Generate a Graph showing each packet Length"+
                "\n1-TCP Port Service Multiplexer (TCPMUX)"+
                "\n5-Remote Job Entry (RJE)"+
                "\n7-ECHO"+
                "\n18-Message Send Protocol (MSP)"+
                "\n20-FTP -- Data"+
                "\n21-FTP -- Control"+
                "\n22-SSH Remote Login Protocol"+
                "\n23-Telnet"+
                "\n25-Simple Mail Transfer Protocol (SMTP)"+
                "\n29-MSG ICP"+
                "\n37-Time"+
                "\n42-Host Name Server (Nameserv)"+
                "\n43-WhoIs"+
                "\n49-Login Host Protocol (Login)"+
                "\n53-Domain Name System (DNS)"+
                "\n69-Trivial File Transfer Protocol (TFTP)"+
                "\n70-Gopher Services"+
                "\n79-Finger"+
                "\n80-HTTP"+
                "\n103-X.400 Standard"+
                "\n108-SNA Gateway Access Server"+
                "\n109-POP2"+
                "\n110-POP3"+
                "\n115-Simple File Transfer Protocol (SFTP)"+
                "\n118-SQL Services"+
                "\n119-Newsgroup (NNTP)"+
                "\n137-NetBIOS Name Service"+
                "\n139-NetBIOS Datagram Service"+
                "\n143-Interim Mail Access Protocol (IMAP)"+
                "\n150-NetBIOS Session Service"+
                "\n156-SQL Server"+
                "\n161-SNMP"+
                "\n179-Border Gateway Protocol (BGP)"+
                "\n190-Gateway Access Control Protocol (GACP)"+
                "\n194-Internet Relay Chat (IRC)"+
                "\n197-Directory Location Service (DLS)"+
                "\n389-Lightweight Directory Access Protocol (LDAP)"+
                "\n396-Novell Netware over IP"+
                "\n443-HTTPS"+
                "\n444-Simple Network Paging Protocol (SNPP)"+
                "\n445-Microsoft-DS"+
                "\n458-Apple QuickTime"+
                "\n546-DHCP Client"+
                "\n547-DHCP Server"+
                "\n563-SNEWS"+
                "\n569-MSN"+
                "\n1080-Socks"+
                "\n For more port Information Visit:\nhttps://en.wikipedia.org/wiki/List_of_TCP_and_UDP_port_numbers " ;
        JOptionPane.showMessageDialog(null, MESSAGE);       
    }//GEN-LAST:event_interfacedetailsActionPerformed
    
    public static void main(String args[]) {
       
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(networkpacketanalyser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(networkpacketanalyser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(networkpacketanalyser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(networkpacketanalyser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new networkpacketanalyser().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton capture;
    private javax.swing.JTextField chooseinterface;
    private javax.swing.JButton exit;
    private javax.swing.JButton filter;
    private javax.swing.JButton generetegraph;
    private javax.swing.JButton interfacedetails;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JButton list;
    private javax.swing.JButton load;
    private javax.swing.JButton pause;
    private javax.swing.JTextField porttext;
    private javax.swing.JButton save;
    public static javax.swing.JTextArea textarea;
    // End of variables declaration//GEN-END:variables

}
