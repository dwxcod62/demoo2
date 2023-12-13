<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="https://cdn.tailwindcss.com"></script>
        <title>Login Page</title>
    </head>
    <body class="bg-[#353b48] flex justify-center items-center text-center">
        <form action="loginServlet" method="post" class="w-1/6 all">
            <label for="helper-text" class="block mb-2 text-sm font-medium text-gray-900 dark:text-white">key</label>
            <input
                type="text"
                id="helper-text"
                aria-describedby="helper-text-explanation"
                class="bg-[#8e44ad] border border-[#8e44ad] text-[#8e44ad] text-sm rounded-lg focus:ring-[#8e44ad] focus:border-[#8e44ad] block w-full p-2.5 dark:bg-[#8e44ad] dark:border-white-600 dark:placeholder-white-700 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500"
                placeholder=""
                name="key-input"
            />
            <button  class="bg-blue-500 hover:bg-blue-700 text-white font-bold py-2 px-4 mt-2 rounded">
                Button
            </button>
        </form>
    </body>
</html>

