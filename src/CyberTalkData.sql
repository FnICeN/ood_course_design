-- MySQL dump 10.13  Distrib 8.0.30, for Win64 (x86_64)
--
-- Host: localhost    Database: ood
-- ------------------------------------------------------
-- Server version	8.0.30

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `cyberspeak`
--

DROP TABLE IF EXISTS `cyberspeak`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cyberspeak` (
  `content` varchar(20) NOT NULL,
  `origin` varchar(15) DEFAULT NULL,
  `origin_mean` varchar(100) DEFAULT NULL,
  `now_mean` varchar(100) DEFAULT NULL,
  `using` varchar(15) DEFAULT NULL,
  `sentence` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`content`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cyberspeak`
--

LOCK TABLES `cyberspeak` WRITE;
/*!40000 ALTER TABLE `cyberspeak` DISABLE KEYS */;
INSERT INTO `cyberspeak` VALUES ('emo','音乐风格','一种较为忧伤的音乐风格，一说，英语单词“emotion”','感到悲伤、忧郁','描述感受','最近因为大家都在内卷，我感到有些emo'),('u1s1','贴吧用户','“有一说一”的字母数字谐音','更多用来强调自己所说的话相较于其他人本分、实在','评论','u1s1，这个颜色的汽车是真的好看'),('yyds','电竞圈','用“永远滴神”来嘲讽电竞选手Uzi，来反击其粉丝的吹嘘，“yyds”是“永远滴神”的拼音首字母','形容某物非常厉害、具有讨人喜爱的特点','生活分享','我们中国队都是yyds！'),('内卷','一篇论文','在农业领域的激烈竞争导致生态变化','在一个特殊的环境下，尽管环境内的每个人都在努力争取自身利益，但是大家越努力，造成无畏的损耗越大，社会整体利益并没有得到提升','社会研究','当今社会，大学生们为了将来能有一份更好的工作，都在拼命内卷'),('夺笋哪','网络主播','“多损那”的变音，用于形容某件事或某人的行为','与原意一致','形容他人','你看看你做的事，夺笋哪！'),('家人们','小红书','与自己有亲缘关系的人','对他人的友善称呼','称呼他人','家人们，我今天干了一件大事'),('寄','游戏','“GoodGame”首字母“G”的中文谐音，游戏结束后评价对手的操作很好','某事物被毁或突然中断，也可引申为“死”','感叹','没带作业，寄！'),('心满离','评论区','心满意足地离开评论区','因在评论区看到自己想要的吐槽而满意地离开','评论','终于看到这句话，心满离'),('摆烂','NBA','一些球队通过故意输球的方式让自己的排名尽可能地排在后面,目的是在第二年的夏天可以有更好的选秀顺位','当事情已经无法向好的方向发展，于是就干脆不再采取措施加以控制而是任由其往坏的方向继续发展下去','游戏圈','对我来说，新学期的开始就是摆烂的开始'),('有内味了','网络主播','“有那味了”的方言说法，指某人身上有其他人的影子','指某人或某事的特性、行为容易使人联想到另一个事物','形容','他一穿上格子衫，就有内味了'),('破防','游戏','在战斗时，装备或防具被打破，失去原有的保护效果，或是某个攻击无视了防御效果','人的心里防御被突破，产生尴尬、悲伤的体验，或是被戳到痛处','伤心事','看完这个视频后，我深深地破防了'),('社死','美国的一本书','指“社会性死亡”：社会上再也没有人记得或知晓某人','因遭遇或被他人揭露尴尬、难堪的事情而导致没脸见人','糗事分享','昨天一不小心进错厕所了，差点社死'),('祖安人','游戏','游戏中的一个以骂人、素质差闻名的大区“祖安区”，在这个大区中的人被称为“祖安人”','形容某人爱骂人','形容他人','你是祖安人吧，嘴巴这么不干净'),('细嗦','贴吧用户','“细说”的方言说法，希望某人能详细说明一下','与原意一致','追问','来个老哥细嗦一下'),('芭比Q了','网络主播','“芭比Q”原意是音译的“烧烤”单词','完蛋了、将某件事搞砸了','糗事分享','芭比Q了，我的作业忘在家里了'),('虎狼之词','德云社','较为大胆的发言','说出口之后，听起来不太纯洁的发言','形容某话','这是什么虎狼之词？');
/*!40000 ALTER TABLE `cyberspeak` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `relation`
--

DROP TABLE IF EXISTS `relation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `relation` (
  `content` varchar(20) NOT NULL,
  `rela` varchar(20) NOT NULL,
  PRIMARY KEY (`content`,`rela`),
  CONSTRAINT `content` FOREIGN KEY (`content`) REFERENCES `cyberspeak` (`content`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `relation`
--

LOCK TABLES `relation` WRITE;
/*!40000 ALTER TABLE `relation` DISABLE KEYS */;
INSERT INTO `relation` VALUES ('yyds','永远滴神'),('夺笋哪','笋都让你夺完了'),('家人们','家人'),('寄','G'),('寄','GG'),('心满离','意满离'),('心满离','看满离'),('摆烂','开摆'),('摆烂','摆'),('细嗦','细锁');
/*!40000 ALTER TABLE `relation` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-02-15 15:47:56
