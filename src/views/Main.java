package views;

import controller.MaterialManager;
import model.CrispyFlour;
import model.Material;
import model.Meat;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main
{
    public static List<Material> materialList = new ArrayList<>();
    public static MaterialManager materialManager = new MaterialManager(materialList);

    public static Material createMaterial()
    {
        Scanner input = new Scanner(System.in);
        boolean result = false;
        String id, name,manufacturingDate;
        int cost;
        LocalDate localDate;
        Material material = null;
        do
        {
            System.out.println("Mời bạn lựa chọn");;
            System.out.println("1. Meat");
            System.out.println("2. Crispy Flour");

            System.out.print("Type = ");
            String type = input.next();
            switch (type)
            {
                case "1":
                    System.out.print("ID = ");
                    id = input.next();
                    input = new Scanner(System.in);
                    System.out.print("Name = ");
                    name = input.nextLine();
                    System.out.print("Cost = ");
                    cost = Integer.parseInt(input.nextLine());
                    System.out.print("Weight = ");
                    double weight = Double.parseDouble(input.nextLine());
                    System.out.print("Manufacturing Date = ");
                    manufacturingDate = input.nextLine();
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
                    localDate = LocalDate.parse(manufacturingDate, formatter);
                    material = new Meat(id, name, localDate, cost, weight);
                    result = true;
                    break;
                case "2":
                    System.out.print("ID = ");
                    id = input.next();
                    input = new Scanner(System.in);
                    System.out.print("Name = ");
                    name = input.nextLine();
                    System.out.print("Cost = ");
                    cost = Integer.parseInt(input.nextLine());
                    System.out.print("Quantity = ");
                    int quantity = Integer.parseInt(input.nextLine());
                    System.out.print("Manufacturing Date = ");
                    manufacturingDate = input.nextLine();
                    localDate = LocalDate.parse(manufacturingDate);
                    material = new CrispyFlour(id, name, localDate, cost, quantity);
                    result = true;
                    break;
            }
        }
        while (!result);
        return  material;
    }

    public static void removeMaterial()
    {
        Scanner input = new Scanner(System.in);
        System.out.print("Nhập id = ");
        String id =  input.nextLine();

        boolean removeResult = materialManager.removeMaterial(id);

        if (removeResult)
        {
            System.out.println("Xóa thành công");
        }
        else
        {
            System.out.println("ID không tồn tại");
        }
    }
    public static void updateMaterial()
    {
        Scanner input = new Scanner(System.in);
        System.out.print("Nhập id = ");
        String id = input.nextLine();
        System.out.print("Nhập tên = ");
        String name = input.nextLine();

        boolean updateResult = materialManager.updateMaterial(id,name );
        if (updateResult)
        {
            System.out.println("Cập nhật thành công");
        }
        else
        {
            System.out.println("ID không tồn tại");
        }
    }

    public static void main(String[] args)
    {
        programTest();
    }

    public static void programTest()
    {
        Scanner input = new Scanner(System.in);
        String type = "";
        do {
            System.out.println("Mời bạn lựa chọn");;
            System.out.println("1. Thêm");
            System.out.println("2. Xóa");
            System.out.println("3. Sửa");
            System.out.println("4. Exit");
            System.out.print("Type = ");
            type = input.next();
            switch (type)
            {
                case "1":
                    Material material = createMaterial();
                    boolean addCheck = materialManager.addMaterial(material);

                    if (addCheck)
                    {
                        System.out.println("Đã tồn tại ID !");
                    }
                    else
                    {
                        System.out.println("Thêm thành công");
                        materialManager.displayMaterial();
                    }
                    break;

                case "2":
                    removeMaterial();
                    break;
                case "3":
                    updateMaterial();
                    break;
                case "4":
                    System.exit(4);
            }
        }
        while (type.equals("1") || type.equals("2") || type.equals("3"));
    }



}