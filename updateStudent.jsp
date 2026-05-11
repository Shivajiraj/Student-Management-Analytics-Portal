<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="UTF-8">

<meta name="viewport"
content="width=device-width, initial-scale=1.0">

<title>Update Student</title>

<link href="https://fonts.googleapis.com/css2?family=Space+Grotesk:wght@400;600;700&family=Poppins:wght@300;400;500;600&display=swap" rel="stylesheet">

<link rel="stylesheet"
href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css"/>

<style>

*{
    margin:0;
    padding:0;
    box-sizing:border-box;
}

body{

    background:
    linear-gradient(
    135deg,
    #050816,
    #111827);

    font-family:'Poppins',sans-serif;

    color:white;

    min-height:100vh;

    display:flex;

    justify-content:center;

    align-items:center;

    padding:40px;
}

.container{

    width:100%;

    max-width:1100px;

    background:
    rgba(17,25,40,0.75);

    border:
    1px solid rgba(168,85,247,0.2);

    backdrop-filter:blur(12px);

    border-radius:25px;

    padding:40px;
}

h1{

    font-size:42px;

    margin-bottom:35px;

    font-family:'Space Grotesk',sans-serif;

    background:
    linear-gradient(
    135deg,
    #f59e0b,
    #a855f7);

    -webkit-background-clip:text;

    -webkit-text-fill-color:transparent;
}

.search-box{

    display:flex;

    gap:20px;

    margin-bottom:40px;
}

.search-box input{

    flex:1;
}

input,
select{

    width:100%;

    padding:16px;

    border-radius:16px;

    border:
    1px solid rgba(255,255,255,0.08);

    background:
    rgba(255,255,255,0.05);

    color:white;

    font-size:15px;
}

input:focus,
select:focus{

    outline:none;

    border-color:#a855f7;

    box-shadow:
    0 0 15px rgba(168,85,247,0.25);
}

button{

    padding:16px 30px;

    border:none;

    border-radius:16px;

    cursor:pointer;

    font-size:15px;

    font-weight:600;
}

.search-btn{

    background:
    linear-gradient(
    135deg,
    #a855f7,
    #06b6d4);

    color:white;
}

.update-btn{

    background:
    linear-gradient(
    135deg,
    #22c55e,
    #06b6d4);

    color:white;
}

.form-grid{

    display:grid;

    grid-template-columns:
    repeat(auto-fit,minmax(300px,1fr));

    gap:25px;
}

.section-title{

    margin:30px 0 20px;

    font-size:24px;

    color:#c084fc;
}

.form-group{

    display:flex;

    flex-direction:column;
}

label{

    margin-bottom:10px;

    color:#dbeafe;
}

.buttons{

    margin-top:35px;

    display:flex;

    gap:20px;
}

.back-btn{

    background:
    rgba(255,255,255,0.08);

    color:white;

    transition:0.3s;
}

.back-btn:hover{

    background:
    rgba(255,255,255,0.15);
}

</style>

</head>

<body>

<div class="container">

    <h1>Update Student</h1>

    <!-- SEARCH -->

    <form action="FetchStudentServlet"
    method="get">

        <div class="search-box">

            <input type="text"
            name="student_id"
            placeholder="Enter Student ID"
            required>

            <button type="submit"
            class="search-btn">

                Search Student

            </button>

        </div>

    </form>

    <!-- UPDATE FORM -->

    <form action="UpdateStudentServlet"
    method="post">

        <!-- hidden id -->

        <input type="hidden"
        name="student_id"
        value="${student_id}">

        <h2 class="section-title">

            Basic Details

        </h2>

        <div class="form-grid">

            <div class="form-group">

                <label>Full Name</label>

                <input type="text"
                name="full_name"
                value="${full_name}">

            </div>

            <div class="form-group">

                <label>Email</label>

                <input type="email"
                name="email"
                value="${email}">

            </div>

            <div class="form-group">

                <label>Phone</label>

                <input type="text"
                name="phone"
                value="${phone}">

            </div>

            <div class="form-group">

                <label>Gender</label>

                <select name="gender">

                    <option>${gender}</option>

                    <option>Male</option>

                    <option>Female</option>

                    <option>Other</option>

                </select>

            </div>

        </div>

        <!-- ACADEMIC -->

        <h2 class="section-title">

            Academic Details

        </h2>

        <div class="form-grid">

            <div class="form-group">

                <label>Branch</label>

                <input type="text"
                name="branch"
                value="${branch}">

            </div>

            <div class="form-group">

                <label>Year</label>

                <input type="text"
                name="year_of_study"
                value="${year_of_study}">

            </div>

            <div class="form-group">

                <label>Section</label>

                <input type="text"
                name="section"
                value="${section}">

            </div>

            <div class="form-group">

                <label>CGPA</label>

                <input type="text"
                name="cgpa"
                value="${cgpa}">

            </div>

        </div>

<div class="buttons">

    <button type="submit"
    class="update-btn">

        Update Student

    </button>

    <button type="button"
    class="back-btn"
    onclick="window.location.href='adminHome.html'">

        Back To Dashboard

    </button>

</div>

    </form>

</div>

</body>
</html>