package com.ufpb.crm;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class Mensagem {



    public String getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(String destinatario) {
        this.destinatario = destinatario;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }
    public void setAssunto(String assunto) {
        this.assunto = assunto;
    }
    public String getAssunto() {
        return assunto;
    }


    private String destinatario;
    private String cliente;
    private String mensagem;
    private String assunto;


    public void enviarMensagem (String destinatario, String assunto, String mensagem) {
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class",
                "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");

        Session session = Session.getDefaultInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication()
                    {
                        return new PasswordAuthentication("nando.oliveirajr1993@gmail.com",
                                "23112019");
                    }
                });

        session.setDebug(true);

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("Nando"));


            Address[] toUser = InternetAddress
                    .parse(destinatario);

            message.setRecipients(Message.RecipientType.TO,toUser);
            message.setSubject(assunto);
            message.setText(mensagem);

            Transport.send(message);

            System.out.println("Feito!!!");

        } catch (MessagingException e)

        {
            throw new RuntimeException(e);
        }
    }




}
