USE [master]
GO
/****** Object:  Database [PRJ321_SE61546_Lab]    Script Date: 09/12/2015 23:39:21 ******/
CREATE DATABASE [PRJ321_SE61546_Lab] ON  PRIMARY 
( NAME = N'JBLab', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL10_50.SQL2008\MSSQL\DATA\JBLab.mdf' , SIZE = 2048KB , MAXSIZE = UNLIMITED, FILEGROWTH = 1024KB )
 LOG ON 
( NAME = N'JBLab_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL10_50.SQL2008\MSSQL\DATA\JBLab_log.ldf' , SIZE = 1024KB , MAXSIZE = 2048GB , FILEGROWTH = 10%)
GO
ALTER DATABASE [PRJ321_SE61546_Lab] SET COMPATIBILITY_LEVEL = 100
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [PRJ321_SE61546_Lab].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [PRJ321_SE61546_Lab] SET ANSI_NULL_DEFAULT OFF
GO
ALTER DATABASE [PRJ321_SE61546_Lab] SET ANSI_NULLS OFF
GO
ALTER DATABASE [PRJ321_SE61546_Lab] SET ANSI_PADDING OFF
GO
ALTER DATABASE [PRJ321_SE61546_Lab] SET ANSI_WARNINGS OFF
GO
ALTER DATABASE [PRJ321_SE61546_Lab] SET ARITHABORT OFF
GO
ALTER DATABASE [PRJ321_SE61546_Lab] SET AUTO_CLOSE OFF
GO
ALTER DATABASE [PRJ321_SE61546_Lab] SET AUTO_CREATE_STATISTICS ON
GO
ALTER DATABASE [PRJ321_SE61546_Lab] SET AUTO_SHRINK OFF
GO
ALTER DATABASE [PRJ321_SE61546_Lab] SET AUTO_UPDATE_STATISTICS ON
GO
ALTER DATABASE [PRJ321_SE61546_Lab] SET CURSOR_CLOSE_ON_COMMIT OFF
GO
ALTER DATABASE [PRJ321_SE61546_Lab] SET CURSOR_DEFAULT  GLOBAL
GO
ALTER DATABASE [PRJ321_SE61546_Lab] SET CONCAT_NULL_YIELDS_NULL OFF
GO
ALTER DATABASE [PRJ321_SE61546_Lab] SET NUMERIC_ROUNDABORT OFF
GO
ALTER DATABASE [PRJ321_SE61546_Lab] SET QUOTED_IDENTIFIER OFF
GO
ALTER DATABASE [PRJ321_SE61546_Lab] SET RECURSIVE_TRIGGERS OFF
GO
ALTER DATABASE [PRJ321_SE61546_Lab] SET  DISABLE_BROKER
GO
ALTER DATABASE [PRJ321_SE61546_Lab] SET AUTO_UPDATE_STATISTICS_ASYNC OFF
GO
ALTER DATABASE [PRJ321_SE61546_Lab] SET DATE_CORRELATION_OPTIMIZATION OFF
GO
ALTER DATABASE [PRJ321_SE61546_Lab] SET TRUSTWORTHY OFF
GO
ALTER DATABASE [PRJ321_SE61546_Lab] SET ALLOW_SNAPSHOT_ISOLATION OFF
GO
ALTER DATABASE [PRJ321_SE61546_Lab] SET PARAMETERIZATION SIMPLE
GO
ALTER DATABASE [PRJ321_SE61546_Lab] SET READ_COMMITTED_SNAPSHOT OFF
GO
ALTER DATABASE [PRJ321_SE61546_Lab] SET HONOR_BROKER_PRIORITY OFF
GO
ALTER DATABASE [PRJ321_SE61546_Lab] SET  READ_WRITE
GO
ALTER DATABASE [PRJ321_SE61546_Lab] SET RECOVERY FULL
GO
ALTER DATABASE [PRJ321_SE61546_Lab] SET  MULTI_USER
GO
ALTER DATABASE [PRJ321_SE61546_Lab] SET PAGE_VERIFY CHECKSUM
GO
ALTER DATABASE [PRJ321_SE61546_Lab] SET DB_CHAINING OFF
GO
EXEC sys.sp_db_vardecimal_storage_format N'PRJ321_SE61546_Lab', N'ON'
GO
USE [PRJ321_SE61546_Lab]
GO
/****** Object:  Table [dbo].[Product]    Script Date: 09/12/2015 23:39:21 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Product](
	[Code] [char](5) NOT NULL,
	[Name] [char](50) NOT NULL,
	[Description] [char](255) NULL,
	[Price] [float] NOT NULL,
	[Category] [char](25) NULL,
 CONSTRAINT [PK_Product] PRIMARY KEY CLUSTERED 
(
	[Code] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
INSERT [dbo].[Product] ([Code], [Name], [Description], [Price], [Category]) VALUES (N'b0001', N'Coca Cola                                         ', N'                        img/coca-cola2.jpg                                                                                                                                                                                                                     ', 0.5, N'Beverage                 ')
INSERT [dbo].[Product] ([Code], [Name], [Description], [Price], [Category]) VALUES (N'b0002', N'Pepsi                                             ', N'                        img/pepsi1.jpg                                                                                                                                                                                                                         ', 0.5, N'Beverage                 ')
INSERT [dbo].[Product] ([Code], [Name], [Description], [Price], [Category]) VALUES (N'b0003', N'test                                              ', N'                                                                                                                                                                                                                                                               ', 100, N'Beverage                 ')
