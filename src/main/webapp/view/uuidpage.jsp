<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>UUID Generator</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <style>
        body, html {
            height: 100%;
            margin: 0;
        }
        body.dark-mode {
            background-color: #333; /* Dark mode background */
            color: #fff;
        }
        .container {
            position: relative;
            padding: 20px;
            text-align: center;
            width: 90%;
            max-width: 600px;
            margin: auto;
            top: 50%;
            transform: translateY(-50%);
        }
        .text-label {
            display: block;
            margin: 20px auto;
            padding: 10px;
            background-color: rgba(0, 0, 0, 0.5);
            color: #fff;
            border-radius: 5px;
            width: 100%;
        }
        .btn-copy-highlight {
            background-color: #90ee90;
        }
        @media (max-width: 768px) {
            .container {
                width: 100%;
                padding: 10px;
                top: 0;
                transform: none;
            }
        }
    </style>
</head>
<body class="dark-mode"> <!-- Ensures dark mode is active by default -->

<div class="container">
    <div class="text-label" id="textToDisplay">Awaiting data...</div>
    <button type="button" class="btn btn-primary" onclick="fetchText()">
        <i class="fas fa-sync-alt"></i> Generate
    </button>
    <button type="button" class="btn btn-secondary" id="copyButton" onclick="copyText()">
        <i class="fas fa-copy"></i> Copy
    </button>
    <button type="button" class="btn btn-dark" id="modeToggle" onclick="toggleMode()"> <!-- Updated for accurate initial state -->
        <i class="fas fa-sun"></i> Light
    </button>
</div>

<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<script>
    document.addEventListener('DOMContentLoaded', () => {
        // Ensures the page loads with dark mode styles applied
        toggleMode(true); // Pass true to indicate initial load
    });

    function fetchText() {
        const url = "<%=request.getContextPath()%>/generatekey";
        fetch(url)
            .then(response => response.text())
            .then(data => {
                document.getElementById('textToDisplay').textContent = data;
            })
            .catch(error => console.error('Error:', error));
    }

    function copyText() {
        const input = document.createElement('input');
        document.body.appendChild(input);
        input.value = document.getElementById('textToDisplay').textContent;
        input.select();
        document.execCommand('copy');
        document.body.removeChild(input);

        const copyButton = document.getElementById('copyButton');
        copyButton.classList.add('btn-copy-highlight');
        setTimeout(() => copyButton.classList.remove('btn-copy-highlight'), 2000);
    }

    function toggleMode(initial = false) {
        if (!initial) document.body.classList.toggle('dark-mode');
        const modeToggle = document.getElementById('modeToggle');
        const modeIcon = modeToggle.querySelector('i');
        const isDarkMode = document.body.classList.contains('dark-mode');

        if (isDarkMode) {
            modeIcon.className = 'fas fa-moon';
            modeToggle.innerHTML = '<i class="fas fa-moon"></i> Dark';
            modeToggle.classList.replace('btn-light', 'btn-dark');
        } else {
            modeIcon.className = 'fas fa-sun';
            modeToggle.innerHTML = '<i class="fas fa-sun"></i> Light';
            modeToggle.classList.replace('btn-dark', 'btn-light');
            document.body.classList.remove('dark-mode'); // This ensures the body reflects the current mode
        }
    }
</script>

</body>
</html>
