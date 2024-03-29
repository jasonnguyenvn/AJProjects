USE [master]
GO
/****** Object:  Database [ProjectJWeb]    Script Date: 10/05/2015 19:20:49 ******/
CREATE DATABASE [ProjectJWeb] ON  PRIMARY 
( NAME = N'ProjectJWeb', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL10_50.SQL2008\MSSQL\DATA\ProjectJWeb.mdf' , SIZE = 2048KB , MAXSIZE = UNLIMITED, FILEGROWTH = 1024KB )
 LOG ON 
( NAME = N'ProjectJWeb_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL10_50.SQL2008\MSSQL\DATA\ProjectJWeb_log.ldf' , SIZE = 1024KB , MAXSIZE = 2048GB , FILEGROWTH = 10%)
GO
ALTER DATABASE [ProjectJWeb] SET COMPATIBILITY_LEVEL = 100
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [ProjectJWeb].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [ProjectJWeb] SET ANSI_NULL_DEFAULT OFF
GO
ALTER DATABASE [ProjectJWeb] SET ANSI_NULLS OFF
GO
ALTER DATABASE [ProjectJWeb] SET ANSI_PADDING OFF
GO
ALTER DATABASE [ProjectJWeb] SET ANSI_WARNINGS OFF
GO
ALTER DATABASE [ProjectJWeb] SET ARITHABORT OFF
GO
ALTER DATABASE [ProjectJWeb] SET AUTO_CLOSE OFF
GO
ALTER DATABASE [ProjectJWeb] SET AUTO_CREATE_STATISTICS ON
GO
ALTER DATABASE [ProjectJWeb] SET AUTO_SHRINK OFF
GO
ALTER DATABASE [ProjectJWeb] SET AUTO_UPDATE_STATISTICS ON
GO
ALTER DATABASE [ProjectJWeb] SET CURSOR_CLOSE_ON_COMMIT OFF
GO
ALTER DATABASE [ProjectJWeb] SET CURSOR_DEFAULT  GLOBAL
GO
ALTER DATABASE [ProjectJWeb] SET CONCAT_NULL_YIELDS_NULL OFF
GO
ALTER DATABASE [ProjectJWeb] SET NUMERIC_ROUNDABORT OFF
GO
ALTER DATABASE [ProjectJWeb] SET QUOTED_IDENTIFIER OFF
GO
ALTER DATABASE [ProjectJWeb] SET RECURSIVE_TRIGGERS OFF
GO
ALTER DATABASE [ProjectJWeb] SET  DISABLE_BROKER
GO
ALTER DATABASE [ProjectJWeb] SET AUTO_UPDATE_STATISTICS_ASYNC OFF
GO
ALTER DATABASE [ProjectJWeb] SET DATE_CORRELATION_OPTIMIZATION OFF
GO
ALTER DATABASE [ProjectJWeb] SET TRUSTWORTHY OFF
GO
ALTER DATABASE [ProjectJWeb] SET ALLOW_SNAPSHOT_ISOLATION OFF
GO
ALTER DATABASE [ProjectJWeb] SET PARAMETERIZATION SIMPLE
GO
ALTER DATABASE [ProjectJWeb] SET READ_COMMITTED_SNAPSHOT OFF
GO
ALTER DATABASE [ProjectJWeb] SET HONOR_BROKER_PRIORITY OFF
GO
ALTER DATABASE [ProjectJWeb] SET  READ_WRITE
GO
ALTER DATABASE [ProjectJWeb] SET RECOVERY FULL
GO
ALTER DATABASE [ProjectJWeb] SET  MULTI_USER
GO
ALTER DATABASE [ProjectJWeb] SET PAGE_VERIFY CHECKSUM
GO
ALTER DATABASE [ProjectJWeb] SET DB_CHAINING OFF
GO
EXEC sys.sp_db_vardecimal_storage_format N'ProjectJWeb', N'ON'
GO
USE [ProjectJWeb]
GO
/****** Object:  Table [dbo].[tbl_users]    Script Date: 10/05/2015 19:20:51 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[tbl_users](
	[username] [varchar](50) NOT NULL,
	[password] [varchar](20) NOT NULL,
	[lastname] [varchar](50) NOT NULL,
	[isAdmin] [bit] NOT NULL,
 CONSTRAINT [PK_tbl_users] PRIMARY KEY CLUSTERED 
(
	[username] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
INSERT [dbo].[tbl_users] ([username], [password], [lastname], [isAdmin]) VALUES (N'admin', N'123456', N'Admin', 1)
INSERT [dbo].[tbl_users] ([username], [password], [lastname], [isAdmin]) VALUES (N'conghau', N'123456', N'abc', 0)
INSERT [dbo].[tbl_users] ([username], [password], [lastname], [isAdmin]) VALUES (N'conghau1', N'123456', N'Cong Hau', 0)
INSERT [dbo].[tbl_users] ([username], [password], [lastname], [isAdmin]) VALUES (N'conghau2', N'123456', N'Cong Hau', 0)
INSERT [dbo].[tbl_users] ([username], [password], [lastname], [isAdmin]) VALUES (N'conghau4', N'123456', N'abc', 0)
INSERT [dbo].[tbl_users] ([username], [password], [lastname], [isAdmin]) VALUES (N'hau', N'123456', N'Hau', 0)
INSERT [dbo].[tbl_users] ([username], [password], [lastname], [isAdmin]) VALUES (N'nhat', N'123456', N'Nhat', 1)
/****** Object:  Table [dbo].[tbl_products]    Script Date: 10/05/2015 19:20:51 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[tbl_products](
	[title] [char](50) NOT NULL,
	[price] [float] NOT NULL,
 CONSTRAINT [PK_tbl_products] PRIMARY KEY CLUSTERED 
(
	[title] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
INSERT [dbo].[tbl_products] ([title], [price]) VALUES (N'EJB                                               ', 12.33)
INSERT [dbo].[tbl_products] ([title], [price]) VALUES (N'J2EE                                              ', 21.05)
INSERT [dbo].[tbl_products] ([title], [price]) VALUES (N'JBoss                                             ', 17)
INSERT [dbo].[tbl_products] ([title], [price]) VALUES (N'JSP                                               ', 10)
INSERT [dbo].[tbl_products] ([title], [price]) VALUES (N'Servlet                                           ', 15)
INSERT [dbo].[tbl_products] ([title], [price]) VALUES (N'Sun                                               ', 14.3)
INSERT [dbo].[tbl_products] ([title], [price]) VALUES (N'Tomcat                                            ', 19.6)
/****** Object:  Table [dbo].[tbl_orders]    Script Date: 10/05/2015 19:20:51 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[tbl_orders](
	[orderID] [int] IDENTITY(1,1) NOT NULL,
	[custLastName] [varchar](50) NOT NULL,
 CONSTRAINT [PK_tbl_orders] PRIMARY KEY CLUSTERED 
(
	[orderID] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
SET IDENTITY_INSERT [dbo].[tbl_orders] ON
INSERT [dbo].[tbl_orders] ([orderID], [custLastName]) VALUES (3, N'GUEST CUSTOMER')
INSERT [dbo].[tbl_orders] ([orderID], [custLastName]) VALUES (4, N'GUEST CUSTOMER')
INSERT [dbo].[tbl_orders] ([orderID], [custLastName]) VALUES (5, N'GUEST CUSTOMER')
INSERT [dbo].[tbl_orders] ([orderID], [custLastName]) VALUES (6, N'GUEST CUSTOMER')
INSERT [dbo].[tbl_orders] ([orderID], [custLastName]) VALUES (7, N'GUEST CUSTOMER')
INSERT [dbo].[tbl_orders] ([orderID], [custLastName]) VALUES (8, N'GUEST CUSTOMER')
INSERT [dbo].[tbl_orders] ([orderID], [custLastName]) VALUES (9, N'GUEST CUSTOMER')
INSERT [dbo].[tbl_orders] ([orderID], [custLastName]) VALUES (10, N'GUEST CUSTOMER')
INSERT [dbo].[tbl_orders] ([orderID], [custLastName]) VALUES (11, N'GUEST CUSTOMER')
SET IDENTITY_INSERT [dbo].[tbl_orders] OFF
/****** Object:  Table [dbo].[tbl_order_detail]    Script Date: 10/05/2015 19:20:51 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[tbl_order_detail](
	[orderID] [int] NOT NULL,
	[title] [char](50) NOT NULL,
	[price] [float] NOT NULL,
	[quantity] [int] NOT NULL,
 CONSTRAINT [PK_tbl_order_detail] PRIMARY KEY CLUSTERED 
(
	[orderID] ASC,
	[title] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
INSERT [dbo].[tbl_order_detail] ([orderID], [title], [price], [quantity]) VALUES (3, N'J2EE                                              ', 21.05, 1)
INSERT [dbo].[tbl_order_detail] ([orderID], [title], [price], [quantity]) VALUES (3, N'Servlet                                           ', 15, 2)
INSERT [dbo].[tbl_order_detail] ([orderID], [title], [price], [quantity]) VALUES (3, N'Sun                                               ', 14.3, 1)
INSERT [dbo].[tbl_order_detail] ([orderID], [title], [price], [quantity]) VALUES (4, N'J2EE                                              ', 21.05, 1)
INSERT [dbo].[tbl_order_detail] ([orderID], [title], [price], [quantity]) VALUES (4, N'JBoss                                             ', 17, 1)
INSERT [dbo].[tbl_order_detail] ([orderID], [title], [price], [quantity]) VALUES (4, N'Servlet                                           ', 15, 2)
INSERT [dbo].[tbl_order_detail] ([orderID], [title], [price], [quantity]) VALUES (5, N'J2EE                                              ', 21.05, 1)
INSERT [dbo].[tbl_order_detail] ([orderID], [title], [price], [quantity]) VALUES (5, N'JBoss                                             ', 17, 1)
INSERT [dbo].[tbl_order_detail] ([orderID], [title], [price], [quantity]) VALUES (5, N'Servlet                                           ', 15, 2)
INSERT [dbo].[tbl_order_detail] ([orderID], [title], [price], [quantity]) VALUES (6, N'J2EE                                              ', 21.05, 2)
INSERT [dbo].[tbl_order_detail] ([orderID], [title], [price], [quantity]) VALUES (6, N'JBoss                                             ', 17, 1)
INSERT [dbo].[tbl_order_detail] ([orderID], [title], [price], [quantity]) VALUES (6, N'Servlet                                           ', 15, 2)
INSERT [dbo].[tbl_order_detail] ([orderID], [title], [price], [quantity]) VALUES (8, N'Servlet                                           ', 15, 2)
INSERT [dbo].[tbl_order_detail] ([orderID], [title], [price], [quantity]) VALUES (10, N'EJB                                               ', 12.33, 1)
INSERT [dbo].[tbl_order_detail] ([orderID], [title], [price], [quantity]) VALUES (11, N'EJB                                               ', 12.33, 3)
INSERT [dbo].[tbl_order_detail] ([orderID], [title], [price], [quantity]) VALUES (11, N'J2EE                                              ', 21.05, 2)
INSERT [dbo].[tbl_order_detail] ([orderID], [title], [price], [quantity]) VALUES (11, N'Servlet                                           ', 15, 3)
INSERT [dbo].[tbl_order_detail] ([orderID], [title], [price], [quantity]) VALUES (11, N'Sun                                               ', 14.3, 1)
/****** Object:  ForeignKey [FK_tbl_order_detail_tbl_orders]    Script Date: 10/05/2015 19:20:51 ******/
ALTER TABLE [dbo].[tbl_order_detail]  WITH CHECK ADD  CONSTRAINT [FK_tbl_order_detail_tbl_orders] FOREIGN KEY([orderID])
REFERENCES [dbo].[tbl_orders] ([orderID])
GO
ALTER TABLE [dbo].[tbl_order_detail] CHECK CONSTRAINT [FK_tbl_order_detail_tbl_orders]
GO
/****** Object:  ForeignKey [FK_tbl_order_detail_tbl_products]    Script Date: 10/05/2015 19:20:51 ******/
ALTER TABLE [dbo].[tbl_order_detail]  WITH CHECK ADD  CONSTRAINT [FK_tbl_order_detail_tbl_products] FOREIGN KEY([title])
REFERENCES [dbo].[tbl_products] ([title])
GO
ALTER TABLE [dbo].[tbl_order_detail] CHECK CONSTRAINT [FK_tbl_order_detail_tbl_products]
GO
