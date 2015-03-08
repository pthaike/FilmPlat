package scu.edu.cn.action;
import java.util.List;
import java.util.Properties;
import javax.mail.Address;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.apache.struts2.ServletActionContext;

import scu.edu.cn.model.UserInfo;
import scu.edu.cn.model.UserInfoDAO;

import com.opensymphony.xwork2.ActionSupport;

public class Mail extends ActionSupport {

    /**
     * ���û������ʼ�
     */
    private static final long serialVersionUID = 1L;

    private MimeMessage mimeMsg; // MIME�ʼ�����

    private Session session; // �ʼ��Ự����

    private Properties props; // ϵͳ����

    private boolean needAuth = false; // smtp�Ƿ���Ҫ��֤

    private String username = ""; // smtp��֤�û���������

    private String password = "";

    private Multipart mp; // Multipart����,�ʼ�����,����,���������ݾ���ӵ����к�������
    
    private String userName;
    
    private String CheckCode;

    /**
	 * @param checkCode the checkCode to set
	 */
	public void setCheckCode(String checkCode) {
		CheckCode = checkCode;
	}

	/**
	 * @return the checkCode
	 */
	public String getCheckCode() {
		return CheckCode;
	}

	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}

	public Mail() {

    }

    public Mail(String smtp) {
        setSmtpHost(smtp);
        createMimeMessage();
    }

    public void setSmtpHost(String hostName) {
        System.out.println("����ϵͳ���ԣ�mail.smtp.host = " + hostName);
        if (props == null)
            props = System.getProperties(); // ���ϵͳ���Զ���
        props.put("mail.smtp.host", hostName); // ����SMTP����
    }

    public boolean createMimeMessage() {
        try {
            System.out.println("׼����ȡ�ʼ��Ự����");
            session = Session.getDefaultInstance(props, null); // ����ʼ��Ự����
        } catch (Exception e) {
            System.err.println("��ȡ�ʼ��Ự����ʱ��������" + e);
            return false;
        }
        System.out.println("׼������MIME�ʼ�����");
        try {
            mimeMsg = new MimeMessage(session); // ����MIME�ʼ�����
            mp = new MimeMultipart(); // mp һ��multipart����
            // Multipart is a container that holds multiple body parts.
            return true;
        } catch (Exception e) {
            System.err.println("����MIME�ʼ�����ʧ�ܣ�" + e);
            return false;
        }
    }

    public void setNeedAuth(boolean need) {
        System.out.println("����smtp�����֤��mail.smtp.auth = " + need);
        if (props == null)
            props = System.getProperties();
        if (need) {
            props.put("mail.smtp.auth", "true");
        } else {
            props.put("mail.smtp.auth", "false");
        }
    }

    public void setNamePass(String name, String pass) {
        System.out.println("����õ��û���������");
        username = name;
        password = pass;
    }

    public boolean setSubject(String mailSubject) {
        System.out.println("�����ʼ����⣡");
        try {
            mimeMsg.setSubject(mailSubject);
            return true;
        } catch (Exception e) {
            System.err.println("�����ʼ����ⷢ������");
            return false;
        }
    }

    public boolean setBody(String mailBody) {
        try {
            System.out.println("�����ʼ����ʽ");
            BodyPart bp = new MimeBodyPart();
            // ת�������ĸ�ʽ
            bp.setContent(
                    "<meta http-equiv=Content-Type content=text/html; charset=gb2312>"
                            + mailBody, "text/html;charset=GB2312");
            mp.addBodyPart(bp);
            return true;
        } catch (Exception e) {
            System.err.println("�����ʼ�����ʱ��������" + e);
            return false;
        }
    }

    public boolean setFrom(String from) {
        System.out.println("���÷����ˣ�");
        try {
            mimeMsg.setFrom(new InternetAddress(from)); // ���÷�����
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean setTo(String to) {
        System.out.println("����������");
        if (to == null)
            return false;
        try {
            mimeMsg.setRecipients(Message.RecipientType.TO, InternetAddress
                    .parse(to));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean setCopyTo(String copyto) {
        System.out.println("���͸�����");
        if (copyto == null)
            return false;
        try {
            mimeMsg.setRecipients(Message.RecipientType.CC,
                    (Address[]) InternetAddress.parse(copyto));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean sendout() {
        try {
            mimeMsg.setContent(mp);
            mimeMsg.saveChanges();
            System.out.println("���ڷ����ʼ�....");
            Session mailSession = Session.getInstance(props, null);
            Transport transport = mailSession.getTransport("smtp");
            transport.connect((String) props.get("mail.smtp.host"), username,
                    password);
            transport.sendMessage(mimeMsg, mimeMsg
                    .getRecipients(Message.RecipientType.TO));
            // transport.send(mimeMsg);
            System.out.println("�����ʼ��ɹ���");
            transport.close();
            return true;
        } catch (Exception e) {
            System.err.println("�ʼ�����ʧ�ܣ�" + e);
            return false;
        }
    }
    @Override
    public String execute() throws Exception {
        // TODO Auto-generated method stub
    	String RightCheck=(String)ServletActionContext.getRequest().getSession().getAttribute("CheckCodeImageAction");
    	if(!RightCheck.equals(CheckCode))
    		return "CheckCodeError";
    	//��¼�û��������û�ע��ʱ�����������Ϣ
    	UserInfoDAO sysDAO = new UserInfoDAO();
    	List userList= sysDAO.findByUserName2(userName);
    	if(userList.isEmpty())
    		return "error";
		UserInfo userInfo=(UserInfo) userList.get(0);
		String sendtoMail=userInfo.getUserEmail();
		String password=userInfo.getUserPassword();
    	//�����ʼ�������
        String mailbody ="��������Ϊ"+password+",�յ����ʼ����뼰ʱɾ����";
        
        //����SMTP����  ��������Ϊsmtp.163.com
        Mail themail = new Mail("smtp.qq.com");
        themail.setNeedAuth(true);
        // ����
        themail.setSubject("�һ�����");

        // �ʼ����� ֧��html �� <font color=red>��ӭ��,java</font>
        themail.setBody(mailbody);
        // �ռ�������
       // themail.setTo("chengzezhou@qq.com");
        themail.setTo(sendtoMail);
        // ����������
        themail.setFrom("chengzezhou@qq.com");

        themail.setNamePass("965648348", "142625199511220018"); // �û���������,����ѡ��һ���Լ��ĵ���
        themail.sendout();
        return "ok";
    }

}

