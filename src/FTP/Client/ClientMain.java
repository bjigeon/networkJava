package network.src.FTP.Client;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class ClientMain {
    Socket socket = new Socket("127.0.0.1",7777);

    static File filePath = new File("");

    String fileName = "";

    Scanner scanner = new Scanner(System.in);

    DataInputStream dis = new DataInputStream(new BufferedInputStream(socket.getInputStream()));

    DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(socket.getOutputStream()));

    public ClientMain() throws IOException {
    }

    public boolean login() throws IOException {
        while (true) {
            System.out.println("아이디와 비밀번호를 입력하세요");

            System.out.printf("아이디 : ");
            String ID = scanner.nextLine().trim();

            System.out.printf("비번 : ");
            String PW = scanner.nextLine().trim();

            String IdPw = ID + " " +PW;
            dos.writeUTF(IdPw);
            dos.flush();

            if (dis.readBoolean()){
                return true;
            }else {
                System.out.printf("\n아이디 비번을 다시 입력하세요\n\n");
            }
        }
    }

    public void setFileNameAndPath(String path){
        String[] tmpPath;

        // 빈칸 있음
        if (path.contains(" ")){
            tmpPath = path.split(" ",2);

            fileName = tmpPath[1];
            filePath = new File(tmpPath[0]);
        }
        //빈칸 없음
        else {
            tmpPath = path.split("/");

            fileName = tmpPath[tmpPath.length - 1];
            filePath = new File(path);
        }
    }

    public void showMenuAndReceiveCmd() throws IOException {
        while (true){
            //메뉴 출력
            System.out.println("ls : 파일 목록 보기 (서버에 저장된 파일 목록)");
            System.out.println("upload : 파일 업로드 (예 : upload 파일경로 파일명  OR  upload 파일경로)");
            System.out.println("download : 파일 다운로드 (서버에 저장된 파일) (예 : download 파일명)");
            System.out.println("disconnect : 접속 종료");

            //명령어 받기
            String Cmd = scanner.nextLine();

            if (Cmd.equals("ls") || Cmd.equals("LS")) {
                showFileList();
            }
            else if (Cmd.equals("disconnect") || Cmd.equals("DISCONNECT")) {
                disconnect();
                break;
            }
            else{
                String[] tmpCmd = Cmd.split(" ", 2);
                if (tmpCmd[0].equals("upload") || tmpCmd[0].equals("UPLOAD")) {
                    setFileNameAndPath(tmpCmd[1]);
                    uploadFile();
                } else if (tmpCmd[0].equals("download") || tmpCmd[0].equals("DOWNLOAD")) {
                    download(tmpCmd[1]);
                }
            }

        }
    }

    public void disconnect() throws IOException {
        System.out.println("연결을 종료합니다.");
        dos.writeUTF("server Close");
        dos.flush();
        socket.close();
    }

    public void showFileList() throws IOException {
        dos.writeUTF("show Files");
        dos.flush();

        int len = dis.readInt();
        for (int i = 0; i < len; i ++){
            System.out.println(dis.readUTF());
        }
    }

    public void uploadFile() throws IOException {
        if (filePath.exists()){
            System.out.println("파일과 보낼 파일명이 확인되었습니다. 파일 전송을 시작합니다.");

            dos.writeUTF(fileName + " " + "upload");
            dos.flush();

            dos.writeLong(filePath.length());
            dos.flush();


            String ex =  dis.readUTF();
            if (ex.equals("exist")){
                System.out.println("파일이 이미 존재 합니다. 파일을 덮어 쓰겠습니까? Yes/No");

                String an = scanner.nextLine();
                dos.writeUTF(an);
                dos.flush();

                if (an.equals("y") || an.equals("Y")){
                    BufferedInputStream bis = new BufferedInputStream(new FileInputStream(filePath));

                    byte[] bytes = new byte[5120];
                    int readbit = -1;

                    while ((readbit = bis.read(bytes)) > 0) {
                        dos.write(bytes, 0, readbit);
                    }
                    dos.flush();
                    bis.close();
                }

            }
            else if(ex.equals("notexist")){
                BufferedInputStream bis = new BufferedInputStream(new FileInputStream(filePath));

                byte[] bytes = new byte[5120];
                int readbit = -1;

                while ((readbit = bis.read(bytes)) > 0) {
                    dos.write(bytes, 0, readbit);
                }
                dos.flush();
                bis.close();
            }

        }
        else {
            System.out.println("파일 경로가 잘못 되었습니다. 다시 입력하세요.");
        }
    }

    public void download(String filename) throws IOException {
        System.out.println("다운로드 진입");

        fileName = filename;
        dos.writeUTF(fileName + " " + "download");
        dos.flush();

        BufferedOutputStream bos = new BufferedOutputStream(
                new FileOutputStream("/Users/bjigeon/Desktop/" + fileName)
        );

        long size = dis.readLong();
        byte[] bytes = new byte[5120];
        int readbit = 0;

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

        System.out.println("파일 다운로드를 완료하였습니다");

    }

    public static void main(String[] args) throws IOException {
        System.out.println("클라이언트 시작");

        ClientMain c = new ClientMain();

        if (c.login()){
            c.showMenuAndReceiveCmd();
        }
    }
}


//        upload /Users/bjigeon/Desktop/aa.jpeg
//        upload /Users/bjigeon/Desktop/m.MP4
//        download cc.jpeg