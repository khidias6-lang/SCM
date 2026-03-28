import java.util.*;

public class baitapaa {
    private String name;
    private int age;
    private double gpa;

    public baitapaa(String name, int age, double gpa) {
        this.name = name;
        this.age = age;
        this.gpa = gpa;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double getGpa() {
        return gpa;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    public void display() {
        System.out.println("Name: " + name + ", Age: " + age + ", GPA: " + gpa);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<baitapaa> list = new ArrayList<>();
        int choice;

        do {
            System.out.println("\n===== MENU =====");
            System.out.println("1. Nhap danh sach");
            System.out.println("2. Hien thi danh sach");
            System.out.println("3. Them sinh vien");
            System.out.println("4. Xoa theo ten");
            System.out.println("5. Sua thong tin theo ten");
            System.out.println("6. Tim kiem theo ten");
            System.out.println("7. Sap xep GPA giam dan");
            System.out.println("8. GPA cao nhat");
            System.out.println("9. GPA thap nhat");
            System.out.println("10. Trung binh GPA");
            System.out.println("0. Thoat");
            System.out.print("Chon: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    list.clear();
                    System.out.print("Nhap so luong: ");
                    int n = sc.nextInt();
                    sc.nextLine();
                    for (int i = 0; i < n; i++) {
                        System.out.print("Ten: ");
                        String name = sc.nextLine();
                        System.out.print("Tuoi: ");
                        int age = sc.nextInt();
                        System.out.print("GPA: ");
                        double gpa = sc.nextDouble();
                        sc.nextLine();
                        list.add(new baitapaa(name, age, gpa));
                    }
                    break;

                case 2:
                    for (baitapaa sv : list) {
                        sv.display();
                    }
                    break;

                case 3:
                    System.out.print("Ten: ");
                    String name = sc.nextLine();
                    System.out.print("Tuoi: ");
                    int age = sc.nextInt();
                    System.out.print("GPA: ");
                    double gpa = sc.nextDouble();
                    sc.nextLine();
                    list.add(new baitapaa(name, age, gpa));
                    break;

                case 4:
                    System.out.print("Nhap ten can xoa: ");
                    String tenXoa = sc.nextLine();
                    Iterator<baitapaa> it = list.iterator();
                    while (it.hasNext()) {
                        if (it.next().getName().equalsIgnoreCase(tenXoa)) {
                            it.remove();
                        }
                    }
                    break;

                case 5:
                    System.out.print("Nhap ten can sua: ");
                    String tenSua = sc.nextLine();
                    for (baitapaa sv : list) {
                        if (sv.getName().equalsIgnoreCase(tenSua)) {
                            System.out.print("Ten moi: ");
                            sv.setName(sc.nextLine());
                            System.out.print("Tuoi moi: ");
                            sv.setAge(sc.nextInt());
                            System.out.print("GPA moi: ");
                            sv.setGpa(sc.nextDouble());
                            sc.nextLine();
                        }
                    }
                    break;

                case 6:
                    System.out.print("Nhap ten can tim: ");
                    String tenTim = sc.nextLine();
                    for (baitapaa sv : list) {
                        if (sv.getName().toLowerCase().contains(tenTim.toLowerCase())) {
                            sv.display();
                        }
                    }
                    break;

                case 7:
                    Collections.sort(list, new Comparator<baitapaa>() {
                        public int compare(baitapaa a, baitapaa b) {
                            return Double.compare(b.getGpa(), a.getGpa());
                        }
                    });
                    break;

                case 8:
                    if (!list.isEmpty()) {
                        baitapaa max = list.get(0);
                        for (baitapaa sv : list) {
                            if (sv.getGpa() > max.getGpa()) {
                                max = sv;
                            }
                        }
                        max.display();
                    }
                    break;

                case 9:
                    if (!list.isEmpty()) {
                        baitapaa min = list.get(0);
                        for (baitapaa sv : list) {
                            if (sv.getGpa() < min.getGpa()) {
                                min = sv;
                            }
                        }
                        min.display();
                    }
                    break;

                case 10:
                    if (!list.isEmpty()) {
                        double sum = 0;
                        for (baitapaa sv : list) {
                            sum += sv.getGpa();
                        }
                        System.out.println("GPA trung binh: " + (sum / list.size()));
                    }
                    break;
            }
        } while (choice != 0);

        sc.close();
    }
}