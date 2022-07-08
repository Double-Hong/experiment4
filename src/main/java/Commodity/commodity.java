package Commodity;


import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class commodity {
    String commId;
    String classifyId;
    String brandId;
    String commName;
    String commSize;
    String modelNumber;
    String unitOfMeasure;
    float marketPrice;
    float salePrice;
    float costPrice;
    String commPhoto;
    String commIntro;
    float inventoryNum;

//    public commodity(String commId, String classifyId, String brandId,
//                     String commName, String commSize, String modelNumber,
//                     String unitOfMeasure, float marketPrice, float salePrice,
//                     float costPrice, String commPhoto, String commIntro, float inventoryNum) {
//        this.commId = commId;
//        this.classifyId = classifyId;
//        this.brandId = brandId;
//        this.commName = commName;
//        this.commSize = commSize;
//        this.modelNumber = modelNumber;
//        this.unitOfMeasure = unitOfMeasure;
//        this.marketPrice = marketPrice;
//        this.salePrice = salePrice;
//        this.costPrice = costPrice;
//        this.commPhoto = commPhoto;
//        this.commIntro = commIntro;
//        this.inventoryNum = inventoryNum;
//    }


}
