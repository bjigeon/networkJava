package network.src.FTP.Server;

import java.io.*;
import java.net.Socket;

public class ServerThread extends Thread{

    static File filePath = new File("");

    static String fileName = "";

    static Socket socket;

    static DataInputStream dis;

    static DataOutputStream dos;

    static FileOutputStream fos;


    public ServerThread(Socket socket) throws IOException {
        this.socket = socket;
        System.out.println(socket.getInetAddress() +"가 접속하였습니다.");
        dis = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
        dos = new DataOutputStream(new BufferedOutputStream(socket.getOutputStream()));
        this.start();
    }

    public void run(){
        String line = null;

        try {
            login();
        } catch (IOException e) {
//            throw new RuntimeException(e);
        }

        while (true) {

            try {
                line = dis.readUTF();
            } catch (IOException e) {
//                throw new RuntimeException(e);
            }

            if (line.equals("server Close")) {
                System.out.println(socket.getInetAddress() + "가 로그아웃 하였습니다");
                try {
                    socket.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }finally {
                    break;
                }
            } else if (line.equals("show Files")) {
                try {
                    showFileList();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }else {

                String[] Cmd = line.split(" ", 2);
                fileName = Cmd[0];
                String cmd = Cmd[1];


                try {
                    if (cmd.equals("upload")) {
                        uploadFile();
                    } else if (cmd.equals("download")) {
                        downloadFile();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void login() throws IOException {
        while (true) {
            String[] IdPw = dis.readUTF().split(" ", 2);
            String id = IdPw[0];
            String pw = IdPw[1];

            if (id.equals("admin") && pw.equals("1234")) {
                System.out.println(socket.getInetAddress() +"가 로그인에 성공하였습니다.");
                dos.writeBoolean(true);
                dos.flush();
                break;
            }
            System.out.println(socket.getInetAddress() +"가 로그인에 실패하였습니다.");
            dos.writeBoolean(false);
            dos.flush();
        }
    }

    public void showFileList() throws IOException {
        File ServerFile = new File("/Users/bjigeon/Desktop/Server/");
        File[] fileList = ServerFile.listFiles();

        dos.writeInt(fileList.length);
        for (File file : fileList){
            dos.writeUTF(String.valueOf(file));
            dos.flush();
        }
        System.out.println();
    }

    public static boolean overWrite() throws IOException {
        dos.writeUTF("overwrite");
        dos.flush();

        String an = dis.readUTF();
        if (an.equals("Y") || an.equals("y") || an.equals("yes") || an.equals("YES")){
            return true;
        }
        else {
            return false;
        }
    }

    //클라 기준 업로드
    public static void uploadFile() throws IOException {

        File serverFile = new File("/Users/bjigeon/Desktop/Server/" + fileName);

        long size = dis.readLong();

        byte[] bytes = new byte[5120];
        int readbit = 0;

        if (serverFile.exists()){
            BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(serverFile));
            dos.writeUTF("exist");
            dos.flush();

            String an = dis.readUTF();
            if (an.equals("y") || an.equals("Y")){

                while (true) {
                    readbit = dis.read(bytes);
                    bos.write(bytes, 0, readbit);
                    size -= readbit;
                    if (size <= 0) {
                        break;
                    }
                }
                bos.flush();
                bos.close();

                dos.writeUTF("파일을 덮어 썼습니다");
                dos.flush();

            }else {
                dos.writeUTF("파일을 덮어 쓰지 않았습니다");
                dos.flush();
            }

        }
        else {
            BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(serverFile));
            dos.writeUTF("notexist");
            dos.flush();

            while (true) {
                readbit = dis.read(bytes);
                bos.write(bytes, 0, readbit);
                size -= readbit;
                if (size <= 0) {
                    break;
                }
            }
            bos.flush();
            bos.close();
        }
        

        System.out.println("파일 업로드를 완료하였습니다");
    }

    //클라 기준 다운
    public void downloadFile() throws IOException {

        filePath = new File("/Users/bjigeon/Desktop/Server/" + fileName);

        dos.writeLong(filePath.length());

        BufferedInputStream bis = new BufferedInputStream(
                new FileInputStream(filePath)
        );

        byte[] bytes = new byte[5120];
        int readbit = -1;

        while ((readbit = bis.read(bytes)) > 0) {
            dos.write(bytes, 0, readbit);
        }
        dos.flush();
        bis.close();

        System.out.println("다운로드 완료");
    }

}

//           upload /Users/bjigeon/Desktop/aa.jpeg