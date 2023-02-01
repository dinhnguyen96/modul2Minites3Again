package controller;

import model.Material;

import java.util.List;

public class MaterialManager {

    private List<Material> materialList;

    public MaterialManager(List<Material> materialList)
    {
        this.materialList = materialList;
    }
    public void displayMaterial()
    {
        for (Material material:materialList)
        {
            System.out.println(material.getId() + " " + material.getName() + " " + material.getCost());
        }
    }
    public boolean addMaterial(Material material)
    {
        for (Material materialCheck : materialList)
        {
            if (materialCheck.getId().equals(material.getId()))
            {
                return true;
            }
        }
       this.materialList.add(material);
       return false;
    }
    public boolean removeMaterial(String id)
    {
        int position = -1;
        for (int i = 0; i < materialList.size(); i++)
        {
            if (materialList.get(i).getId().equals(id))
            {
                position = i;
                break;
            }
        }
        if (position == -1)
        {
            return false;
        }
        else
        {
            materialList.remove(position);
            return true;
        }

    }
    public boolean updateMaterial(String id, String materialName)
    {
        int position = -1;
        for (int i = 0; i < materialList.size(); i++)
        {
            if (materialList.get(i).getId().equals(id))
            {
                position = i;
                break;
            }
        }
        if (position == -1)
        {
            return false;
        }
        else
        {
            Material material = materialList.get(position);
            material.setName(materialName);
            return true;
        }
    }
}
