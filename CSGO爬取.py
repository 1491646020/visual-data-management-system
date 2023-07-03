#定义url
import pymysql
import requests



url = "https://csgo.wanmei.com/api/items"
headers={"User-Agent":"Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/114.0.0.0 Safari/537.36",
        "Accept":"application/json, text/javascript, */*; q=0.01",
"Accept-Encoding":"gzip, deflate, br",
"Accept-Language":"zh-CN,zh;q=0.9",
"Connection":"keep-alive",
"Host":"csgo.wanmei.com",
"Origin":"https://www.csgo.com.cn",
"Referer":"https://www.csgo.com.cn/",
"Sec-Ch-Ua-Mobile":"?0",
"Sec-Ch-Ua-Platform":"Windows",
"Sec-Fetch-Dest":"empty",
"Sec-Fetch-Mode":"cors",
"Sec-Fetch-Site":"cross-site"
         }
#请求改url获取响应
rep=requests.get(url,headers=headers)

# print(rep.status_code)

#拿去到json信息
infojson = rep.json()
# print(infojson)
#把它当成字典使用，此时字典内有两个键值对,我们获取result键值对,通过名字拿到值 拿到名为result的字典
results = infojson["result"]
# print(results)
#
#提取key值列表
key_list = list(results.keys())
#打印key值
# print(key_list)



List_of_weapons = []

for x in key_list:
    result = results[x]
    for x in result:
        List_of_weapon = []
        # 武器英文名字
        List_of_weapon.append(x["name"])
        # 武器英文名字
        List_of_weapon.append(x["name_sc"])
        # 武器描述
        List_of_weapon.append(x["description_sc"])
        # 武器类型
        List_of_weapon.append(x["item_slot_sc"])
        # 准确的范围
        List_of_weapon.append(x["accurate_range"])
        # 击杀奖励百分比
        List_of_weapon.append(x["kill_award_percentage"])
        # 价格
        List_of_weapon.append(x["price"])
        # 弹夹最大容量
        List_of_weapon.append(x["clipSizeMax"])
        # 换弹时间
        List_of_weapon.append(x["cycletime"])
        # 伤害
        List_of_weapon.append(x["damage"])
        List_of_weapons.append(List_of_weapon)
print(List_of_weapons)
con= pymysql.connect(host="localhost", database="csgo", user="root", passwd="123456", charset="utf8")
cursor = con.cursor()
sql = "insert into wuqi values (null,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s)"
cursor.executemany(sql,List_of_weapons)
con.commit()
cursor.close()
con.close()




#     heroInfo = []
#     heroInfo.append(hero["heroId"])
#     heroInfo.append(hero["name"])
#     heroInfo.append(hero["armor"])
#     heroInfo.append(hero["armorperlevel"])
#     heroInfo.append(hero["attackdamage"])
#     heroInfo.append(hero["attackdamageperlevel"])
#     heroInfo.append(hero["attackrange"])
#     heroInfo.append(hero["attackspeed"])
#     heroInfo.append(hero["attackspeedperlevel"])
#     heroInfo.append(hero["changeLabel"])
#     heroInfo.append(hero["couponPrice"])
#     heroInfo.append(hero["damageType"])
#     heroInfo.append(hero["goldPrice"])
#     heroInfo.append(hero["hp"])
#     heroInfo.append(hero["hpperlevel"])
#     heroInfo.append(hero["hpregen"])
#     heroInfo.append(hero["hpregenperlevel"])
#     heroInfo.append(hero["movespeed"])
#     heroInfo.append(hero["mp"])
#     heroInfo.append(hero["mpperlevel"])
#     heroInfo.append(hero["mpregen"])
#     heroInfo.append(hero["mpregenperlevel"])
#     heroInfo.append(hero["shortBio"])
#     herosInfo.append(heroInfo)
# con= pymysql.connect(host="localhost", database="enshi", user="root", passwd="123456", charset="utf8")
# cursor = con.cursor()
# sql = "insert into hero_info values (%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s)"
# cursor.executemany(sql,herosInfo)
# con.commit()
# cursor.close()
# con.close()
