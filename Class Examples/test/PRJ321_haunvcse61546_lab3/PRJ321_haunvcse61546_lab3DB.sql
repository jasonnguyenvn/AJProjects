USE [master]
GO
/****** Object:  Database [PRJ321_SE61546_Lab3]    Script Date: 09/18/2015 21:44:48 ******/
CREATE DATABASE [PRJ321_SE61546_Lab3] ON  PRIMARY 
( NAME = N'PRJ321_SE61546_Lab3', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL10_50.SQL2008\MSSQL\DATA\PRJ321_SE61546_Lab3.mdf' , SIZE = 2048KB , MAXSIZE = UNLIMITED, FILEGROWTH = 1024KB )
 LOG ON 
( NAME = N'PRJ321_SE61546_Lab3_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL10_50.SQL2008\MSSQL\DATA\PRJ321_SE61546_Lab3_log.ldf' , SIZE = 1024KB , MAXSIZE = 2048GB , FILEGROWTH = 10%)
GO
ALTER DATABASE [PRJ321_SE61546_Lab3] SET COMPATIBILITY_LEVEL = 100
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [PRJ321_SE61546_Lab3].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [PRJ321_SE61546_Lab3] SET ANSI_NULL_DEFAULT OFF
GO
ALTER DATABASE [PRJ321_SE61546_Lab3] SET ANSI_NULLS OFF
GO
ALTER DATABASE [PRJ321_SE61546_Lab3] SET ANSI_PADDING OFF
GO
ALTER DATABASE [PRJ321_SE61546_Lab3] SET ANSI_WARNINGS OFF
GO
ALTER DATABASE [PRJ321_SE61546_Lab3] SET ARITHABORT OFF
GO
ALTER DATABASE [PRJ321_SE61546_Lab3] SET AUTO_CLOSE OFF
GO
ALTER DATABASE [PRJ321_SE61546_Lab3] SET AUTO_CREATE_STATISTICS ON
GO
ALTER DATABASE [PRJ321_SE61546_Lab3] SET AUTO_SHRINK OFF
GO
ALTER DATABASE [PRJ321_SE61546_Lab3] SET AUTO_UPDATE_STATISTICS ON
GO
ALTER DATABASE [PRJ321_SE61546_Lab3] SET CURSOR_CLOSE_ON_COMMIT OFF
GO
ALTER DATABASE [PRJ321_SE61546_Lab3] SET CURSOR_DEFAULT  GLOBAL
GO
ALTER DATABASE [PRJ321_SE61546_Lab3] SET CONCAT_NULL_YIELDS_NULL OFF
GO
ALTER DATABASE [PRJ321_SE61546_Lab3] SET NUMERIC_ROUNDABORT OFF
GO
ALTER DATABASE [PRJ321_SE61546_Lab3] SET QUOTED_IDENTIFIER OFF
GO
ALTER DATABASE [PRJ321_SE61546_Lab3] SET RECURSIVE_TRIGGERS OFF
GO
ALTER DATABASE [PRJ321_SE61546_Lab3] SET  DISABLE_BROKER
GO
ALTER DATABASE [PRJ321_SE61546_Lab3] SET AUTO_UPDATE_STATISTICS_ASYNC OFF
GO
ALTER DATABASE [PRJ321_SE61546_Lab3] SET DATE_CORRELATION_OPTIMIZATION OFF
GO
ALTER DATABASE [PRJ321_SE61546_Lab3] SET TRUSTWORTHY OFF
GO
ALTER DATABASE [PRJ321_SE61546_Lab3] SET ALLOW_SNAPSHOT_ISOLATION OFF
GO
ALTER DATABASE [PRJ321_SE61546_Lab3] SET PARAMETERIZATION SIMPLE
GO
ALTER DATABASE [PRJ321_SE61546_Lab3] SET READ_COMMITTED_SNAPSHOT OFF
GO
ALTER DATABASE [PRJ321_SE61546_Lab3] SET HONOR_BROKER_PRIORITY OFF
GO
ALTER DATABASE [PRJ321_SE61546_Lab3] SET  READ_WRITE
GO
ALTER DATABASE [PRJ321_SE61546_Lab3] SET RECOVERY FULL
GO
ALTER DATABASE [PRJ321_SE61546_Lab3] SET  MULTI_USER
GO
ALTER DATABASE [PRJ321_SE61546_Lab3] SET PAGE_VERIFY CHECKSUM
GO
ALTER DATABASE [PRJ321_SE61546_Lab3] SET DB_CHAINING OFF
GO
EXEC sys.sp_db_vardecimal_storage_format N'PRJ321_SE61546_Lab3', N'ON'
GO
USE [PRJ321_SE61546_Lab3]
GO
/****** Object:  Table [dbo].[tbl_products]    Script Date: 09/18/2015 21:44:49 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[tbl_products](
	[proID] [int] IDENTITY(1,1) NOT NULL,
	[proName] [varchar](50) NOT NULL,
	[quanPerUnit] [varchar](50) NOT NULL,
	[price] [float] NOT NULL,
 CONSTRAINT [PK_tb_products] PRIMARY KEY CLUSTERED 
(
	[proID] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
SET IDENTITY_INSERT [dbo].[tbl_products] ON
INSERT [dbo].[tbl_products] ([proID], [proName], [quanPerUnit], [price]) VALUES (1, N'Cocacola', N'200ml / can', 2.3)
INSERT [dbo].[tbl_products] ([proID], [proName], [quanPerUnit], [price]) VALUES (2, N'Pepsi', N'200ml / can', 2.2)
INSERT [dbo].[tbl_products] ([proID], [proName], [quanPerUnit], [price]) VALUES (3, N'7up', N'200ml / can', 1.75)
INSERT [dbo].[tbl_products] ([proID], [proName], [quanPerUnit], [price]) VALUES (4, N'Lipton', N'100 bags / box', 6.22)
INSERT [dbo].[tbl_products] ([proID], [proName], [quanPerUnit], [price]) VALUES (5, N'Monster Enery', N'400ml / can', 2.5)
INSERT [dbo].[tbl_products] ([proID], [proName], [quanPerUnit], [price]) VALUES (6, N'Aquafina', N'500ml / bottle', 0.5)
INSERT [dbo].[tbl_products] ([proID], [proName], [quanPerUnit], [price]) VALUES (7, N'Lavie', N'500ml / bottle', 0.44)
INSERT [dbo].[tbl_products] ([proID], [proName], [quanPerUnit], [price]) VALUES (8, N'Vinh hao', N'500ml / bottle', 0.33)
INSERT [dbo].[tbl_products] ([proID], [proName], [quanPerUnit], [price]) VALUES (9, N'Meats', N'500gr', 3)
INSERT [dbo].[tbl_products] ([proID], [proName], [quanPerUnit], [price]) VALUES (10, N'Vinamilk', N'320 ml / bag', 1.02)
INSERT [dbo].[tbl_products] ([proID], [proName], [quanPerUnit], [price]) VALUES (12, N'TH True Milk', N'320 ml / bag', 1.22)
INSERT [dbo].[tbl_products] ([proID], [proName], [quanPerUnit], [price]) VALUES (13, N'Hanoi Milk', N'320 ml / bag', 1.33)
INSERT [dbo].[tbl_products] ([proID], [proName], [quanPerUnit], [price]) VALUES (14, N'Long Thanh Milk', N'320 ml / bottle', 1.5)
INSERT [dbo].[tbl_products] ([proID], [proName], [quanPerUnit], [price]) VALUES (15, N'Dutch Lady Milk ', N'320 ml / bag', 1.2)
INSERT [dbo].[tbl_products] ([proID], [proName], [quanPerUnit], [price]) VALUES (16, N'P.S', N'250 gr', 1.5)
INSERT [dbo].[tbl_products] ([proID], [proName], [quanPerUnit], [price]) VALUES (17, N'Colgate', N'250 gr', 1.2)
INSERT [dbo].[tbl_products] ([proID], [proName], [quanPerUnit], [price]) VALUES (18, N'Mirinda', N'200ml / can', 1.63)
INSERT [dbo].[tbl_products] ([proID], [proName], [quanPerUnit], [price]) VALUES (19, N'Nuoc yen', N'200ml / can', 1.22)
INSERT [dbo].[tbl_products] ([proID], [proName], [quanPerUnit], [price]) VALUES (20, N'Redbulls', N'250ml / can', 1.33)
INSERT [dbo].[tbl_products] ([proID], [proName], [quanPerUnit], [price]) VALUES (21, N'7Up Revive', N'350ml / bottle', 2.02)
INSERT [dbo].[tbl_products] ([proID], [proName], [quanPerUnit], [price]) VALUES (22, N'Aquarius', N'350ml / bottle', 2.22)
INSERT [dbo].[tbl_products] ([proID], [proName], [quanPerUnit], [price]) VALUES (23, N'Notebook 200', N'200 pages', 0.7)
INSERT [dbo].[tbl_products] ([proID], [proName], [quanPerUnit], [price]) VALUES (24, N'Notebook 96', N'96 pages', 0.3)
INSERT [dbo].[tbl_products] ([proID], [proName], [quanPerUnit], [price]) VALUES (25, N'Notebook 400', N'400 pages', 1.5)
INSERT [dbo].[tbl_products] ([proID], [proName], [quanPerUnit], [price]) VALUES (26, N'Pen', N'cay', 0.3)
INSERT [dbo].[tbl_products] ([proID], [proName], [quanPerUnit], [price]) VALUES (27, N'Pencile', N'cay', 0.5)
INSERT [dbo].[tbl_products] ([proID], [proName], [quanPerUnit], [price]) VALUES (28, N'Glass', N'cai', 0.8)
INSERT [dbo].[tbl_products] ([proID], [proName], [quanPerUnit], [price]) VALUES (29, N'T-Shirt', N'cai', 6.79)
INSERT [dbo].[tbl_products] ([proID], [proName], [quanPerUnit], [price]) VALUES (30, N'Jeans 1', N'cai', 20)
INSERT [dbo].[tbl_products] ([proID], [proName], [quanPerUnit], [price]) VALUES (31, N'Jeans 2', N'cai', 22.3)
INSERT [dbo].[tbl_products] ([proID], [proName], [quanPerUnit], [price]) VALUES (32, N'Jeans 3', N'cai', 25)
INSERT [dbo].[tbl_products] ([proID], [proName], [quanPerUnit], [price]) VALUES (33, N'Jeans 4', N'cai', 55)
INSERT [dbo].[tbl_products] ([proID], [proName], [quanPerUnit], [price]) VALUES (34, N'T-Shirt Red', N'cai', 44)
INSERT [dbo].[tbl_products] ([proID], [proName], [quanPerUnit], [price]) VALUES (35, N'T-Shirt Blue', N'cai', 33)
INSERT [dbo].[tbl_products] ([proID], [proName], [quanPerUnit], [price]) VALUES (36, N'T-Shirt Pink', N'cai', 28)
INSERT [dbo].[tbl_products] ([proID], [proName], [quanPerUnit], [price]) VALUES (37, N'T-Shirt Gold', N'cai', 33)
INSERT [dbo].[tbl_products] ([proID], [proName], [quanPerUnit], [price]) VALUES (38, N'Iphone 4', N'cai', 50)
INSERT [dbo].[tbl_products] ([proID], [proName], [quanPerUnit], [price]) VALUES (39, N'Iphone 4s', N'cai', 100)
INSERT [dbo].[tbl_products] ([proID], [proName], [quanPerUnit], [price]) VALUES (40, N'Iphone 5', N'cai', 200)
INSERT [dbo].[tbl_products] ([proID], [proName], [quanPerUnit], [price]) VALUES (41, N'Iphone 5s', N'cai', 350)
INSERT [dbo].[tbl_products] ([proID], [proName], [quanPerUnit], [price]) VALUES (42, N'Iphone 6', N'cai', 400)
INSERT [dbo].[tbl_products] ([proID], [proName], [quanPerUnit], [price]) VALUES (43, N'Iphone 6s', N'cai', 700)
INSERT [dbo].[tbl_products] ([proID], [proName], [quanPerUnit], [price]) VALUES (44, N'BKAV BPhone', N'cai', 600)
INSERT [dbo].[tbl_products] ([proID], [proName], [quanPerUnit], [price]) VALUES (45, N'USB Flash Kingstone 2gb', N'4gb', 10)
INSERT [dbo].[tbl_products] ([proID], [proName], [quanPerUnit], [price]) VALUES (47, N'USB Flash Kingstone 4gb', N'8gb', 20)
INSERT [dbo].[tbl_products] ([proID], [proName], [quanPerUnit], [price]) VALUES (49, N'USB Flash Kingstone 16gb', N'16gb', 25)
INSERT [dbo].[tbl_products] ([proID], [proName], [quanPerUnit], [price]) VALUES (50, N'USB Flash Kingstone 32gb', N'32gb', 30)
INSERT [dbo].[tbl_products] ([proID], [proName], [quanPerUnit], [price]) VALUES (51, N'USB Flash Kingmax 2gb', N'2gb', 6)
INSERT [dbo].[tbl_products] ([proID], [proName], [quanPerUnit], [price]) VALUES (52, N'USB Flash Kingmax 4gb', N'4gb', 10)
INSERT [dbo].[tbl_products] ([proID], [proName], [quanPerUnit], [price]) VALUES (54, N'USB Flash Kingmax 8gb', N'8gb', 25)
INSERT [dbo].[tbl_products] ([proID], [proName], [quanPerUnit], [price]) VALUES (55, N'USB Flash Kingmax 16gb', N'16gb', 30)
INSERT [dbo].[tbl_products] ([proID], [proName], [quanPerUnit], [price]) VALUES (56, N'USB Flash Kingmax 32gb', N'32gb', 45)
INSERT [dbo].[tbl_products] ([proID], [proName], [quanPerUnit], [price]) VALUES (57, N'USB Flash Kingmax 40gb', N'40gb', 50)
INSERT [dbo].[tbl_products] ([proID], [proName], [quanPerUnit], [price]) VALUES (58, N'USB Flash Kingmax 100gb', N'100gb', 70)
INSERT [dbo].[tbl_products] ([proID], [proName], [quanPerUnit], [price]) VALUES (59, N'DDR3 Kingstone 2gb', N'2gb', 30)
INSERT [dbo].[tbl_products] ([proID], [proName], [quanPerUnit], [price]) VALUES (60, N'DDR3 Kingstone 4gb', N'4gb', 40)
INSERT [dbo].[tbl_products] ([proID], [proName], [quanPerUnit], [price]) VALUES (61, N'DDR3 Kingstone 8gb', N'8gb', 60)
INSERT [dbo].[tbl_products] ([proID], [proName], [quanPerUnit], [price]) VALUES (62, N'DDR3 Kingmax 2gb', N'2gb', 44)
INSERT [dbo].[tbl_products] ([proID], [proName], [quanPerUnit], [price]) VALUES (64, N'DDR3 Kingmax 4gb', N'4gb', 70)
INSERT [dbo].[tbl_products] ([proID], [proName], [quanPerUnit], [price]) VALUES (65, N'DDR3 Kingmax 8gb', N'8gb', 80)
INSERT [dbo].[tbl_products] ([proID], [proName], [quanPerUnit], [price]) VALUES (66, N'DDR4 Kingstone 2gb', N'2gb', 40)
INSERT [dbo].[tbl_products] ([proID], [proName], [quanPerUnit], [price]) VALUES (67, N'DDR4 Kingstone 4gb', N'4gb', 80)
INSERT [dbo].[tbl_products] ([proID], [proName], [quanPerUnit], [price]) VALUES (69, N'DDR4 Kingstone 8gb', N'8gb', 100)
INSERT [dbo].[tbl_products] ([proID], [proName], [quanPerUnit], [price]) VALUES (70, N'HDD WD 250gb', N'250gb', 70)
INSERT [dbo].[tbl_products] ([proID], [proName], [quanPerUnit], [price]) VALUES (71, N'HDD WD 320gb', N'320gb', 80)
INSERT [dbo].[tbl_products] ([proID], [proName], [quanPerUnit], [price]) VALUES (72, N'HDD WD 500gb', N'500gb', 120)
INSERT [dbo].[tbl_products] ([proID], [proName], [quanPerUnit], [price]) VALUES (73, N'HDD WD 1TB', N'1TB', 150)
INSERT [dbo].[tbl_products] ([proID], [proName], [quanPerUnit], [price]) VALUES (74, N'HDD WD 1.5TB', N'1.5TB', 200)
INSERT [dbo].[tbl_products] ([proID], [proName], [quanPerUnit], [price]) VALUES (75, N'SSD WD 250GB', N'250gb', 150)
INSERT [dbo].[tbl_products] ([proID], [proName], [quanPerUnit], [price]) VALUES (76, N'SSD WD 320GB', N'320gb', 200)
INSERT [dbo].[tbl_products] ([proID], [proName], [quanPerUnit], [price]) VALUES (77, N'SSD WD 500GB', N'500gb', 300)
INSERT [dbo].[tbl_products] ([proID], [proName], [quanPerUnit], [price]) VALUES (78, N'HDD WD Passpore 500GB', N'500GB', 60)
INSERT [dbo].[tbl_products] ([proID], [proName], [quanPerUnit], [price]) VALUES (79, N'HDD WD Passpore 250GB', N'250GB', 50)
INSERT [dbo].[tbl_products] ([proID], [proName], [quanPerUnit], [price]) VALUES (80, N'HDD WD Passpore 1TB', N'1TB', 120)
INSERT [dbo].[tbl_products] ([proID], [proName], [quanPerUnit], [price]) VALUES (81, N'HDD WD Passpore 1.5TB', N'1.5TB', 150)
INSERT [dbo].[tbl_products] ([proID], [proName], [quanPerUnit], [price]) VALUES (82, N'HDD WD Passpore 2TB', N'2TB', 200)
SET IDENTITY_INSERT [dbo].[tbl_products] OFF
/****** Object:  Table [dbo].[tbl_orders]    Script Date: 09/18/2015 21:44:49 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[tbl_orders](
	[ordID] [int] IDENTITY(1,1) NOT NULL,
	[custName] [varchar](100) NOT NULL,
 CONSTRAINT [PK_tbl_orders] PRIMARY KEY CLUSTERED 
(
	[ordID] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
SET IDENTITY_INSERT [dbo].[tbl_orders] ON
INSERT [dbo].[tbl_orders] ([ordID], [custName]) VALUES (1, N'00000')
INSERT [dbo].[tbl_orders] ([ordID], [custName]) VALUES (2, N'Nguyen Van A')
INSERT [dbo].[tbl_orders] ([ordID], [custName]) VALUES (3, N'Nguyen Thi Gai')
SET IDENTITY_INSERT [dbo].[tbl_orders] OFF
/****** Object:  Table [dbo].[tbl_order_detail]    Script Date: 09/18/2015 21:44:49 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tbl_order_detail](
	[ordID] [int] NOT NULL,
	[proID] [int] NOT NULL,
	[price] [float] NOT NULL,
	[quantity] [int] NOT NULL,
 CONSTRAINT [PK_tbl_order_detail] PRIMARY KEY CLUSTERED 
(
	[ordID] ASC,
	[proID] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
INSERT [dbo].[tbl_order_detail] ([ordID], [proID], [price], [quantity]) VALUES (1, 1, 2.2999999523162842, 2)
INSERT [dbo].[tbl_order_detail] ([ordID], [proID], [price], [quantity]) VALUES (1, 5, 2.5, 1)
INSERT [dbo].[tbl_order_detail] ([ordID], [proID], [price], [quantity]) VALUES (1, 7, 0.43999999761581426, 1)
INSERT [dbo].[tbl_order_detail] ([ordID], [proID], [price], [quantity]) VALUES (2, 1, 2.2999999523162842, 1)
INSERT [dbo].[tbl_order_detail] ([ordID], [proID], [price], [quantity]) VALUES (2, 6, 0.5, 1)
INSERT [dbo].[tbl_order_detail] ([ordID], [proID], [price], [quantity]) VALUES (2, 25, 1.5, 1)
INSERT [dbo].[tbl_order_detail] ([ordID], [proID], [price], [quantity]) VALUES (2, 51, 6, 1)
INSERT [dbo].[tbl_order_detail] ([ordID], [proID], [price], [quantity]) VALUES (2, 64, 70, 1)
INSERT [dbo].[tbl_order_detail] ([ordID], [proID], [price], [quantity]) VALUES (3, 67, 80, 1)
/****** Object:  ForeignKey [FK_tbl_order_detail_tb_products]    Script Date: 09/18/2015 21:44:49 ******/
ALTER TABLE [dbo].[tbl_order_detail]  WITH CHECK ADD  CONSTRAINT [FK_tbl_order_detail_tb_products] FOREIGN KEY([proID])
REFERENCES [dbo].[tbl_products] ([proID])
GO
ALTER TABLE [dbo].[tbl_order_detail] CHECK CONSTRAINT [FK_tbl_order_detail_tb_products]
GO
/****** Object:  ForeignKey [FK_tbl_order_detail_tbl_orders]    Script Date: 09/18/2015 21:44:49 ******/
ALTER TABLE [dbo].[tbl_order_detail]  WITH CHECK ADD  CONSTRAINT [FK_tbl_order_detail_tbl_orders] FOREIGN KEY([ordID])
REFERENCES [dbo].[tbl_orders] ([ordID])
GO
ALTER TABLE [dbo].[tbl_order_detail] CHECK CONSTRAINT [FK_tbl_order_detail_tbl_orders]
GO
