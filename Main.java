package main;
 
import java.security.spec.RSAOtherPrimeInfo;
import java.util.Scanner;
 
public class Main {
    static Scanner sc = new Scanner(System.in);
    static void nhapAlbum(Album ab) {
        System.out.print("Nhap ma CD: ");
        ab.setMaCD(sc.nextInt());
        sc.nextLine();
        System.out.print("Nhap ten CD : ");
        ab.setTenCD(sc.nextLine());
        System.out.print("Nhap so luong bai hat : ");
        ab.setSoBH(sc.nextInt());
        System.out.print("Nhap gia thanh : ");
        ab.setGiaThanh(sc.nextFloat());
    }
    public static void main(String[] args) {
        Album alb[] = null;
        int a, n = 0;
        boolean flag = true;
        do {
            System.out.println("Vui long chon chuc nang ");
            System.out.println("1.Them CD \n" +
                    "2.Xuat danh sach Album.\n" + 
            		"3.Tinh tong gia thanh \n" + 
                    "4.Tong so luong CD \n" +
                    "5.Sap xep giam dan theo gia thanh\n"+
                    "6.Sap xep giam dan theo ten CD\n"+
                    "0.Thoat chuong trinh");
            a = sc.nextInt();
            switch (a) {
                case 1:
                    System.out.print("Nhap so luong CD : ");
                    n = sc.nextInt();
                    alb = new Album[n];
                    for (int i = 0; i < n; i++) {
                        System.out.println("CD thu " + (i + 1)+": ");
                        alb[i] = new Album();
                        nhapAlbum(alb[i]);
                    }
                    break;
                case 2:
                    System.out.printf("%-10s %-20s %-10s %-20s \n", "Ma CD", "Ten CD", "So bai hat", "Gia thanh");
                    for (int i = 0; i < n; i++) {
                        alb[i].hienThiAlbum();
                    }
                    break;
                case 3:
                    int tong = 0;
                    for (int i = 0; i < n; i++) {
                        tong += alb[i].getGiaThanh();
                    }
                    System.out.println("" +
                            "Tong gia thanh : " + tong);
                    break;
                case 4:
                    System.out.println("Tong so luong CD la : " + n);
                    break;
                case 5:
                    Album temp = alb[0];
                    for (int i = 0; i < n - 1; i++) {
                        for (int j = i + 1; j < n; j++) {
                            if (alb[i].getGiaThanh() < alb[j].getGiaThanh()) {
                                temp = alb[j];
                                alb[j] = alb[i];
                                alb[i] = temp;
                            }
                        }
                    }
                    System.out.println("Sap xep thanh cong!");
                    break;
                case 6:
                    temp = alb[0];
                    for (int i = 0; i < n - 1; i++) {
                        for (int j = i + 1; j < n; j++) {
                            if (alb[i].getTenCD().compareTo(alb[j].getTenCD())>0) {
                                temp = alb[j];
                                alb[j] = alb[i];
                                alb[i] = temp;
                            }
                        }
                    }
                    System.out.println("Sap xep thanh cong!");
                    break;
                default:
                 
                    flag = false;
                    break;
            }
        }while (flag) ;
    }
}