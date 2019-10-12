/**
 * 
 */



function checkPestType(pest){
	var re ="";
//	﻿1：2：3：4：5：6：7：8：9：10飞虱11：12：13. 14

	switch(pest){
		case "1":
			re = "白粉虱";
			break;
			
		case "2":
			re = "介壳虫";
			break;
			
		case "3":
			re = "稻飞虱";
			break;
			
		case "4":
			re = "蚜虫";
			break;
			
		case "5":
			re = "棉红蜘蛛";
			break;
			
		case "6":
			re = "卷叶蛾";
			break;
			
		case "7":
			re = "蓟马";
			break;
			
		case "8":
			re = "天牛";
			break;
			
		case "9":
			re = "吊丝虫";
			break;
			
		case "10":
			re = "烟青虫";
			break;
			
		case "11":
			re = "地老虎";
			break;
		case "12":
			re = "水稻螟虫";
			break;
		case "13":
			re = "稻赤斑黑沫蝉 ";
			break;
		default:
			break;
	}
}

function checkDiseaseType(disease){
	var re = "";

	switch(disease){
		case "1":
			re = "白粉病";
			break;
		case "2":
			{re = "锈病";
			break;}
		case "3":
			re = "炭疽病";
			break;
		case "4":
			re = "叶斑病";
			break;
		case "5":
			re = "花腐病";
			break;
		case "6":
			re = "煤污病";
			break;
		case "7":
			re = "丛枝病";
			break;
		case "8":
			re = "菟丝子病";
			break;
		case "9":
			re = "稻瘟病";
			break;
		case "10":
			re = "纹枯病";
			break;
		default:
				break;
	}
	return re;
}

